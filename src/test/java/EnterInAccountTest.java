import PageObject.*;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnterInAccountTest extends Base {


    Faker faker = new Faker();
    private String email = faker.internet().emailAddress();
    private String password = faker.internet().password(6, 10);
    private String name = faker.name().username();

    CreatingUser creatingUser = new CreatingUser(email,password,name);
    String token;


    @Step("Создание пользователя для Stellar Burger")
    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.START_URL;
        Response response = creatingUser.creatingUser(creatingUser);
        token =  creatingUser.checkCreatedOK(response);
    }


    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку 'Войти в аккаунт' на главной странице сайта")
    public void checkEnterInAccountOnSitePage() {
        driver.get(Constants.START_URL);
        SitePage sitePage = new SitePage(driver);
        sitePage.clickButtonEnter();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPersonalProfile(email, password);
        sitePage.jumpPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        String text = profilePage.checkValueEmail();
        Assert.assertEquals(email, text);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку 'Личный кабинет' в шапке")
    public void checkEnterInAccountOnPersonalProfile () {
        driver.get(Constants.START_URL);
        SitePage sitePage = new SitePage(driver);
        sitePage.jumpPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPersonalProfile(email, password);
        sitePage.jumpPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        String text = profilePage.checkValueEmail();
        Assert.assertEquals(email, text);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через страницу регистрции")
    public void checkEnterInAccountOnRegisterPage () {
        driver.get(Constants.REGISTER_URL);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPersonalProfile(email, password);
        SitePage sitePage = new SitePage(driver);
        sitePage.jumpPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        String text = profilePage.checkValueEmail();
        Assert.assertEquals(email, text);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку 'Восстановления пароля'")
    public void checkEnterInAccountByRecoverPassword () {
        driver.get(Constants.FORGOT_PASSWORD_URL);
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.clickRecoverPassword();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPersonalProfile(email, password);
        SitePage sitePage = new SitePage(driver);
        sitePage.jumpPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        String text = profilePage.checkValueEmail();
        Assert.assertEquals(email, text);

    }
    @Step("Удаление пользователя Stellar Burger")
    @After
    public void deleteOrder() {
        if (token != null)
            creatingUser.deleteUser(token);
    }
}
