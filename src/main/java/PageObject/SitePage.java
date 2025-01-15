package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SitePage {
    private WebDriver driver;

    private By enterButten = By.xpath(".//button[contains(@class, 'button_button')]");
    private By personalAccountButtonHeader = By.xpath(".//p[contains(@class, 'AppHeader_header__linkText') and text()='Личный Кабинет']");
    private By buildBurger = By.xpath(".//h1[contains(@class, 'text')]");
    private By basketElement = By.xpath(".//section[contains (@class, 'BurgerConstructor_basket')]");
    private By bunsButton = By.xpath(".//span[text()='Булки']");
    private By sauceButton = By.xpath(".//span[text()='Соусы']");
    private By fillingButton = By.xpath(".//span[text()='Начинки']");

    private By bunsTab = By.xpath(".//span[text()='Булки']/parent::div");
    private By sauceTab = By.xpath(".//span[text()='Соусы']/parent::div");
    private By fillingTab = By.xpath(".//span[text()='Начинки']/parent::div");
    private By currentTab = By.xpath(".//div[contains(@class, 'current')]/child::span");

    public SitePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Вход в личный кабинет для неавторизованного пользоватeля")
    public void clickButtonEnter() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(enterButten));
        driver.findElement(enterButten).click();
    }

    @Step("Переход в личный кабинет")
    public void jumpPersonalAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(personalAccountButtonHeader));
        driver.findElement(personalAccountButtonHeader).click();
    }

    @Step("Проверка заголовка страницы блока 'Конструктор'")
    public String checkPageBuildBurger() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(buildBurger));
        return driver.findElement(buildBurger).getText();
    }

    @Step("Проверка открытия главной страницы сайта")
    public boolean checkOpenSitePage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(basketElement));
        return driver.findElement(basketElement).isDisplayed();
    }

    @Step("Переход к разделу 'Соусы'")
    public void clickToSauce() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(sauceButton));
        driver.findElement(sauceButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.attributeContains(sauceTab, "class", "current"));
    }

    @Step("Переход к разделу 'Булки'")
    public void clickToBuns() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(bunsButton));
        driver.findElement(bunsButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.attributeContains(bunsTab, "class", "current"));
    }

    @Step("Переход к разделу 'Начинки'")
    public void clickToFilling() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fillingButton));
        driver.findElement(fillingButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.attributeContains(fillingTab, "class", "current"));
    }

    @Step("Получение названия активной вкладки")
    public String checkCurrentTab() {
        return driver.findElement(currentTab).getText();
    }
}
