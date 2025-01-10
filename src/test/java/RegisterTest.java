import PageObject.LoginPage;
import PageObject.RegisterPage;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class RegisterTest extends Base {

    Faker faker = new Faker();

    public String name = faker.name().firstName();
    public String email = faker.internet().emailAddress();
    public String password = faker.letterify("??????");
    public String passwordIs4Char = faker.letterify("????");

    @Test
    @DisplayName("Проверка регистрации пользователя")
    public void checkRegisterWithRightField() {
        driver.get(Constants.REGISTER_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(name, email, password);
        LoginPage loginPage = new LoginPage(driver);
        boolean result = loginPage.openLoginPage();
        Assert.assertTrue(result);
    }

    @Test
    @DisplayName("Проверка сообщения об ошибки при создании пользователя с паролем из 4 символов")
    public void checkRegisterWithWrongPassword () {
        driver.get(Constants.REGISTER_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(name, email, passwordIs4Char);
        String text = registerPage.textErrorForWrongPassword();
        Assert.assertEquals("Некорректный пароль", text);
    }

}
