import PageObject.RegisterPage;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import java.time.Duration;


public class RegisterTest extends Base {

    Faker faker = new Faker();

    public String name = faker.name().firstName();
    public String email = faker.internet().emailAddress();
    public String password = faker.letterify("??????");
    public String passwordIs4Char = faker.letterify("????");

    @Test
    public void checkRegisterWithRightField () {
        driver.get(Constants.REGISTER_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(name, email, password);
        String text = registerPage.openPageAfterRegister();
        Assert.assertEquals("Войти", text);
  }

    @Test
    public void checkRegisterWithWrongPassword () {
        driver.get(Constants.REGISTER_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser(name, email, passwordIs4Char);
        String text = registerPage.textErrorForWrongPassword();
        Assert.assertEquals("Некорректный пароль", text);

    }

}
