package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SitePage {

    private final WebDriver driver;

    private By enterButten = By.xpath(".//button[contains(@class, 'button_button')]");

    private By personalAccountButton = By.xpath(".//p[contains(@class, 'AppHeader_header__linkText') and text()='Личный Кабинет']");


    public SitePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Вход в личный кабинет для неавторизированного пользоватлея")
    public void clickButtonEnter() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(enterButten));
        driver.findElement(enterButten).click();
    }

    @Step("Переход в личный кабинет авторизированного пользователя")
    public void jumpPersonalAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        driver.findElement(personalAccountButton).click();
    }
}
