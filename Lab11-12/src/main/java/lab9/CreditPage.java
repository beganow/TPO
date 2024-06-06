package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreditPage extends BasePage {
    public CreditPage(WebDriver driver) {
        super(driver);
    }
    public void calcCredit(String money, String year, String FIO, String phone) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement calc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/span/button")));
        calc.click();
        WebElement count = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[11]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/form/div[3]/div/div/div[2]/div/div[1]")));
        count.click();
        WebElement changeMoney = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[11]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/form/div[3]/div/div/div[2]/div/div[1]/div/input")));
        changeMoney.click();
        changeMoney.sendKeys(Keys.CONTROL + "a");
        changeMoney.sendKeys(Keys.DELETE);
        changeMoney.sendKeys(money);
        WebElement changeYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[11]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/form/div[3]/div/div/div[4]/div[1]/div/div[1]/div/input")));
        changeYear.sendKeys(Keys.CONTROL + "a");
        changeYear.sendKeys(Keys.DELETE);
        changeYear.sendKeys(year);
        WebDriverWait wait1 = new WebDriverWait(driver, 10000);
        WebElement goalDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-field-name='credit_purpose']//div[@role='combobox']")));
        goalDropdown.click();
        try {
            Thread.sleep(10000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement fioDiv = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[11]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/form/div[9]/div/div/span/span/div/div")));
        fioDiv.click();
        WebElement fioInput = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("fio")));
        fioInput.click();
        fioInput.sendKeys(FIO);
        WebElement phoneDiv = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[11]/div/div/div/div[2]/div/div/div/div/div[1]/div/div/form/div[10]/div/div/div[1]/div")));
        phoneDiv.click();
        WebElement phoneMobile = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone_mobile")));
        phoneMobile.sendKeys(phone);
    }
    public void  submit(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement buttonSub= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("goForward")));
        buttonSub.click();
    }
}
