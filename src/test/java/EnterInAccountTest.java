import PageObject.*;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnterInAccountTest extends Base {
    CreatingUser creatingUser = GeneratorUser.getRandomUser();

    String token;

    @Step("Создание пользователя для Stellar Burger")
    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.START_URL;
        Response response = creatingUser.creatingUser(creatingUser);
        token = creatingUser.checkCreatedOK(response);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку 'Войти в аккаунт' на главной странице сайта")
    public void enterInAccountOnSitePageTest() {
        driver.get(Constants.START_URL);
        SitePage sitePage = new SitePage(driver);
        sitePage.clickButtonEnter();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPersonalProfile(creatingUser.getEmail(), creatingUser.getPassword());
        sitePage.jumpPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        String text = profilePage.checkValueEmail();
        Assert.assertEquals(creatingUser.getEmail(), text);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку 'Личный кабинет' в шапке")
    public void enterInAccountOnPersonalProfileTest() {
        driver.get(Constants.START_URL);
        SitePage sitePage = new SitePage(driver);
        sitePage.jumpPersonalAccount();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPersonalProfile(creatingUser.getEmail(), creatingUser.getPassword());
        sitePage.jumpPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        String text = profilePage.checkValueEmail();
        Assert.assertEquals(creatingUser.getEmail(), text);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через страницу регистрции")
    public void enterInAccountOnRegisterPageTest() {
        driver.get(Constants.REGISTER_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPersonalProfile(creatingUser.getEmail(), creatingUser.getPassword());
        SitePage sitePage = new SitePage(driver);
        sitePage.jumpPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        String text = profilePage.checkValueEmail();
        Assert.assertEquals(creatingUser.getEmail(), text);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку 'Восстановления пароля'")
    public void enterInAccountByRecoverPasswordTest() {
        driver.get(Constants.FORGOT_PASSWORD_URL);
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.clickRecoverPassword();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPersonalProfile(creatingUser.getEmail(), creatingUser.getPassword());
        SitePage sitePage = new SitePage(driver);
        sitePage.jumpPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        String text = profilePage.checkValueEmail();
        Assert.assertEquals(creatingUser.getEmail(), text);
    }

    @Step("Удаление пользователя Stellar Burger")
    @After
    public void deleteOrder() {
        if (token != null)
            creatingUser.deleteUser(token);
    }
}
