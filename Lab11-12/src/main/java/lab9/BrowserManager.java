package lab9;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserManager {
    private WebDriver driver;

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.gecko.driver", "D:\\Загрузки\\webdriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}