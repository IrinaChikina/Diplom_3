
import org.openqa.selenium.WebDriver;

public class OpenPage {
    public WebDriver driver;

    public OpenPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSitePage() {
        driver.get(Constants.START_URL);
    }

    public void openRegisterPage() {
        driver.get(Constants.REGISTER_URL);
    }

    public void openRecoverPasswordPage() {
        driver.get(Constants.FORGOT_PASSWORD_URL);
    }
}
