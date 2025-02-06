package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecoverPasswordPage {
    private WebDriver driver;

    private By enterButton = By.xpath(".//a[@href ='/login']");

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход на страницу входа в личный кабинет со станицы восстановления пароля")
    public void clickRecoverPassword() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(enterButton));
        driver.findElement(enterButton).click();
    }
}