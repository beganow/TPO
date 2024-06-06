package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage extends BasePage {
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public void goToShopPage() {
        driver.get("https://shop.tinkoff.ru/catalog/clothes");
    }
    public void getHoodi(){
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement hoodilist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/section[2]/div[2]/div[2]/div[2]")));
        hoodilist.click();
        WebElement currentHoodi = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/section[2]/div[2]/div[2]/div[3]/div/div[2]/a")));
        currentHoodi.click();
        WebElement addToBuskket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" /html/body/div[2]/section[2]/div[3]/div/div/div/div[5]")));
        addToBuskket.click();
        WebElement transferCard23 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/section[2]/div[3]/div/div/div/div[5]/button")));
        transferCard23.click();
        try {
            Thread.sleep(5000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void delFromBusk() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement busket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[8]")));
        busket.click();
        WebElement deleteFromBusket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[7]/div[3]/div[2]/div[2]/ul/cart-item/li/div[3]/div")));
        deleteFromBusket.click();}
}
