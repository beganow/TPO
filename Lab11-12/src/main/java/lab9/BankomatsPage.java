package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankomatsPage extends  BasePage {
    public BankomatsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage()

    {
        driver.get("https://www.tinkoff.ru/maps/atm/");
    }
    public void fillsum(String sum){
        WebDriverWait wait = new WebDriverWait(driver, 100); // Явное ожидание до 10 секунд
        WebElement sumDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/section/div[1]/div/div")));
        sumDiv.click();
        WebElement sumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/section/div[1]/div/div/div/div[2]/div/span/div/div[2]/div/div/input")));
        sumInput.sendKeys(Keys.CONTROL + "a");
        sumInput.sendKeys(Keys.DELETE);
        sumInput.sendKeys(sum);
        WebElement selectBank = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[3]/div[2]")));
        selectBank.click();
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div[2]/div/label/div[1]")));
        checkbox.click();
        try {
            Thread.sleep(2000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
