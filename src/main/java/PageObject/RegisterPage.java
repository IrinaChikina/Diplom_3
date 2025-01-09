package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;

    private By nameField = By.xpath(".//label[contains(text(), 'Имя')]/following-sibling::input");
    private By emailField = By.xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    private By passwordField = By.xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    private By registerButton = By.className("button_button__33qZ0");
    private By enterButton = By.className("button_button_type_primary__1O7Bx");
    private By headerEnter = By.xpath(".//h2[text()='Вход']");

    private By errorPassword = By.className("input__error");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step ("Регистрация пользователя")
    public void registerNewUser(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registerButton).click();

    }
    @Step("Открытие страницы после успешной регистрации")
    public String openPageAfterRegister() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(headerEnter)));
        return driver.findElement(enterButton).getText();
    }

@Step("Получение текста сообщения об ошибке при заполнении пароля 4 символа")
    public String textErrorForWrongPassword (){
        return driver.findElement(errorPassword).getText();
    }
    //.//p[contains(@class, 'error') and text ()='Некорректный пароль']

}
