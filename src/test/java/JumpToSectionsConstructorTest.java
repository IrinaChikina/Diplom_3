import PageObject.SitePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JumpToSectionsConstructorTest extends Base {

    @Before
    public void openPage() {
        OpenPage openPage = new OpenPage(driver);
        openPage.openSitePage();
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'соусы' в блоке конструктора бургера")
    public void jumpToSauceTest() {
        SitePage sitePage = new SitePage(driver);
        sitePage.clickToSauce();
        String text = sitePage.checkCurrentTab();
        Assert.assertEquals("Соусы", text);
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'булки' в блоке конструктора бургера")
    public void jumpToBunsTest() {
        SitePage sitePage = new SitePage(driver);
        sitePage.clickToSauce();
        sitePage.clickToBuns();
        String text = sitePage.checkCurrentTab();
        Assert.assertEquals("Булки", text);
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'начинки' в блоке конструктора бургера")
    public void jumpToFillingTest() {
        SitePage sitePage = new SitePage(driver);
        sitePage.clickToFilling();
        String text = sitePage.checkCurrentTab();
        Assert.assertEquals("Начинки", text);
    }
}
