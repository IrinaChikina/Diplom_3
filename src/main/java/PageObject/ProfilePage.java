package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private WebDriver driver;

    private By valueFieldEmail = By.xpath(".//input[contains(@name, 'name') and @type='text']");
    private By constructorButtonHeader = By.xpath(".//p[contains(@class, 'AppHeader_header__linkText') and text()='Конструктор'] ");
    private By logoOnHeader = By.xpath(".//div[contains(@class, 'AppHeader_header__logo')]");
    private By exitButton = By.xpath(".//button[contains(@class, 'Account_button')]");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
@Step ("Получение логина авторизованного пользователя")
    public String checkValueEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(valueFieldEmail));
        return driver.findElement(valueFieldEmail).getAttribute("value");
    }

    @Step("Переход на страницу конструктора из личного кабинета")
    public void jumpConstructor() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(constructorButtonHeader));
        driver.findElement(constructorButtonHeader).click();
    }

    @Step("Переход на главную страницу из личного кабинета через логотип")
    public void jumpSitePage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoOnHeader));
        driver.findElement(logoOnHeader).click();
    }


    @Step("Выход из аккаунта")
    public void exitFromProfile() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }

}

