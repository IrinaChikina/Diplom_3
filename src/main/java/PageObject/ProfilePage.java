package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private WebDriver driver;

    private By personalProfileForm = By.xpath(".//div[contains(@class, 'Account_account')]");
    private By valueFieldEmail = By.xpath(".//input[contains(@name, 'name') and @type='text']");


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
@Step ("Получение логина авторизованного пользователя")
    public String checkValueEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(valueFieldEmail));
        return driver.findElement(valueFieldEmail).getAttribute("value");
    }
}
