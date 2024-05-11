import lab9.CreateCard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class WebDriverUnitTest {
    private WebDriver driver;
    private CreateCard tinkoffMainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\Загрузки\\webdriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        tinkoffMainPage = new CreateCard(driver);
    }

    @Test
    public void testButtonClick() throws InterruptedException {
        tinkoffMainPage.open();
        tinkoffMainPage.clickFavouriteProductsLink();
        Thread.sleep(2000);
        assertTrue(tinkoffMainPage.isOnFavouriteProductsPage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}