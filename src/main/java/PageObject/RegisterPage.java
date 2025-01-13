package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    private By nameField = By.xpath(".//label[contains(text(), 'Имя')]/following-sibling::input");
    private By emailField = By.xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    private By passwordField = By.xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    private By registerButton = By.className("button_button__33qZ0");
    private By enterButton = By.xpath(".//a[text()='Войти' and contains(@class, 'Auth_link')]");
    private By errorPassword = By.className("input__error");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Регистрация пользователя")
    public void registerNewUser(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    @Step("Получение текста сообщения об ошибке при заполнении пароля 4 символа")
    public String textErrorForWrongPassword() {
        return driver.findElement(errorPassword).getText();
    }

    @Step("Переход на страницу входа в личный кабинет со станицы регистрации")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}
