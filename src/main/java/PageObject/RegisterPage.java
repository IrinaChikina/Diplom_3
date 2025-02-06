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
    private By enterButton = By.xpath(".//a[text()='Войти' and contains(@class, 'Auth_link')]");
    private By errorPassword = By.className("input__error");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Регистрация: заполнение поля 'Name'")
    public void inputNameFiled(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }
    @Step("Регистрация: заполнение поля 'Email'")
    public void inputEmailFiled(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Регистрация: заполнение поля 'Password'")
    public void inputPasswordFiled(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickButtonOk() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }


    @Step("Регистрация пользователя")
    public void registerNewUser(String name, String email, String password) {
        inputNameFiled(name);
        inputEmailFiled(email);
        inputPasswordFiled(password);
        clickButtonOk();
    }
//    @Step("Регистрация пользователя")
//    public void registerNewUser(String name, String email, String password) {
//        driver.findElement(nameField).sendKeys(name);
//        driver.findElement(emailField).sendKeys(email);
//        driver.findElement(passwordField).sendKeys(password);
//        driver.findElement(registerButton).click();
//    }

    @Step("Получение текста сообщения об ошибке при заполнении пароля 4 символа")
    public String textErrorForWrongPassword() {
        return driver.findElement(errorPassword).getText();
    }

    @Step("Переход на страницу входа в личный кабинет со станицы регистрации")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}
