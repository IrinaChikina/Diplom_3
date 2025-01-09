import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

    public void startFirefox () {
        WebDriverManager.firefoxdriver().setup();
        var opts = new FirefoxOptions()
                .configureFromEnv();
        driver = new FirefoxDriver(opts);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
@Step ("Запуск браузера Google Chrome")
    public void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Step ("Запкск браузера Yandex")
    public void startYandex() {
        WebDriverManager.chromedriver().driverVersion(System.getProperty("driver.version")).setup();
        var opts = new ChromeOptions();
        opts.setBinary(System.getProperty("webdriver.yandex.bin"));
        driver = new ChromeDriver(opts);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



//public static WebDriver createWebDriver() {
//    String browser = System.getProperty("browser");
//    if (browser == null) {
//        return createChromeDriver();
//    }
//
//    switch (browser) {
//        case "yandex":
//            return createYandexDriver();
//        case "chrome":
//        default:
//            return createChromeDriver();
//    }
//}
//
//private static WebDriver createChromeDriver() {
//    ChromeOptions options = new ChromeOptions();
//    return new ChromeDriver(options);
//}
//    // -Dbrowser=yandex -Ddriver.version=124.0.6367.78 -Dwebdriver.yandex.bin=/Applications/Yandex.app
//private static WebDriver createYandexDriver() {
//    System.setProperty("webdriver.chrome.driver",
//            String.format("%s/%s", System.getenv("WEBDRIVERS"),
//                    System.getenv("YANDEX_BROWSER_DRIVER_FILENAME")));
//    ChromeOptions options = new ChromeOptions();
//    options.setBinary(System.getenv("YANDEX_BROWSER_PATH"));
//    return new ChromeDriver(options);
//}
//// WEBDRIVERS  = /Applications/Yandex.app
    }
}





