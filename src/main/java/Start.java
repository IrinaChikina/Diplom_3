import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Start {

    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void initDriver() {
        if ("yandex".equals(System.getProperty("browser"))) {
            startYandex();
        } else {
            startChrome();
        }
    }

    @Step("Запуск браузера Google Chrome")
    public void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Step("Запкск браузера Yandex")
    public void startYandex() {
        WebDriverManager.chromedriver().driverVersion(System.getProperty("driver.version")).setup();
        var opts = new ChromeOptions();
        opts.setBinary(System.getProperty("webdriver.yandex.bin"));
        driver = new ChromeDriver(opts);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}





