import PageObject.LoginPage;
import PageObject.ProfilePage;
import PageObject.SitePage;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExitFromProfileTest extends Base{

    Faker faker = new Faker();
    private String email = faker.internet().emailAddress();
    private String password = faker.internet().password(6, 10);
    private String name = faker.name().username();

    CreatingUser creatingUser = new CreatingUser(email,password,name);
    String token;

    @Step("Создание пользователя для Stellar Burger и вход в личный кабинет")
    @Before
    public void setUp() {
        RestAssured.baseURI = Constants.START_URL;
        Response response = creatingUser.creatingUser(creatingUser);
        token =  creatingUser.checkCreatedOK(response);

        driver.get(Constants.START_URL);
        SitePage sitePage = new SitePage(driver);
        sitePage.clickButtonEnter();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPersonalProfile(email, password);
        sitePage.jumpPersonalAccount();
    }


    @Test
    @DisplayName("Проверка выхода из аккаунта пользователя через кнопку 'выход' в Личном кабинете")
    public void checkExitFromProfile() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.exitFromProfile();
        LoginPage loginPage = new LoginPage(driver);
        boolean result = loginPage.openLoginPage();
        Assert.assertTrue(result);
    }

    @Step("Удаление пользователя Stellar Burger")
    @After
    public void deleteOrder() {
        if (token != null)
            creatingUser.deleteUser(token);
    }
}
