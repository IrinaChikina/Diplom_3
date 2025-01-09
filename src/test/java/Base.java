import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Base {

    public WebDriver driver;

    @Step ("Запуск браузера")
    @Before
    public void initDriver() {
        Start start = new Start();
        start.initDriver();
        driver = start.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Step ("Закрытие браузера")
    @After
    public void teardown() {
        driver.quit();
    }
}
