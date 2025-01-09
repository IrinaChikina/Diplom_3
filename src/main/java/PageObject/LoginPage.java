package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    private By headerEnter = By.xpath(".//h2[contains(text(), 'Вход')]");
    private By emailField = By.xpath(".//input[contains(@class, 'text') and @name='name']");
    private By passwordField = By.xpath(".//input[contains(@class, 'text') and @type='password']");
    private By enterButton = By.xpath(".//button[contains(@class, 'button_button')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void checkOpenLoginPage (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headerEnter));
    }

    private void inputFieldEmail (String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    private void inputFieldPassword (String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    private void clickButtonEnter (){
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(enterButton));
        driver.findElement(enterButton).click();
    }

    @Step("Авторизация пользователя с ранее созданным логином и паролем")
    public void enterPersonalProfile (String email,String password){
        checkOpenLoginPage();
        inputFieldEmail(email);
        inputFieldPassword(password);
        clickButtonEnter();
    }
}
