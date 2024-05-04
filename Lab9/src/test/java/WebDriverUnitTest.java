import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class WebDriverUnitTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Загрузки\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testButtonClick() throws InterruptedException {
        driver.get("https://www.tinkoff.ru/");

        WebElement link = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div/div/ul/li[1]/div/a"));
        link.click();
        Thread.sleep(5000);
        // Проверка, что мы находимся на странице с избранными товарами после нажатия на кнопку
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("debit-cards")); // Предполагаем, что в URL есть "debit-cards
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
