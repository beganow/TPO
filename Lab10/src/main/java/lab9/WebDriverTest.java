package lab9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:\\Загрузки\\webdriver\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        CreateCard tinkoffPage = new CreateCard(driver);

        tinkoffPage.open();
        tinkoffPage.clickFirstButton();
        tinkoffPage.fillForm("Павел Ободов Андреевич", "9212345677", "pashok12obodov@gmail.com", "01032004");
        tinkoffPage.submitForm();

        Thread.sleep(2000);

        driver.quit();
    }
}
