import PageObject.LoginPage;
import PageObject.RegisterPage;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class RegisterTest extends Base {
    CreatingUser creatingUser = GeneratorUser.getRandomUser();

    @Test
    @DisplayName("Проверка регистрации пользователя")
    public void registerWithRightFieldTest() {
        driver.get(Constants.REGISTER_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(creatingUser.getName(), creatingUser.getEmail(), creatingUser.getPassword());
        LoginPage loginPage = new LoginPage(driver);
        boolean result = loginPage.openLoginPage();
        Assert.assertTrue(result);
    }

    @Test
    @DisplayName("Проверка сообщения об ошибки при создании пользователя с паролем из 4 символов")
    public void checkRegisterWithWrongPassword() {
        Faker faker = new Faker();
        String passwordIs4Char = faker.letterify("????");
        driver.get(Constants.REGISTER_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(creatingUser.getName(), creatingUser.getEmail(), passwordIs4Char);
        String text = registerPage.textErrorForWrongPassword();
        Assert.assertEquals("Некорректный пароль", text);
    }
}
