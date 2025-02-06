import PageObject.*;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterInAccountTest extends Base {
    String token;

    CreatingUser creatingUser = GeneratorUser.getRandomUser();
    //OpenPage openPage = new OpenPage(driver);

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
        OpenPage openPage = new OpenPage(driver);
        openPage.openSitePage();
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
        OpenPage openPage = new OpenPage(driver);
        openPage.openSitePage();
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
        OpenPage openPage = new OpenPage(driver);
        openPage.openRegisterPage();
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
        OpenPage openPage = new OpenPage(driver);
        openPage.openRecoverPasswordPage();
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
