package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepositPage extends BasePage {
    public DepositPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement calc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div/div[2]/div/h3/button")));
        calc.click();
    }
    public void info(String money, String countMonth, String FIO, String phone, String birthDate){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement sumDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div/div[2]/div/div/div/div/div[1]/div/div/form/div[2]/div[1]/div/div[1]/div[1]/div[1]/div/div[2]/div")));
        sumDiv.click();
        WebElement sumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div/div[2]/div/div/div/div/div[1]/div/div/form/div[2]/div[1]/div/div[1]/div[1]/div[1]/div/div[2]/div/div/div[2]/div/div[1]/input")));

        sumInput.sendKeys(Keys.CONTROL + "a");
        sumInput.sendKeys(Keys.DELETE);
        sumInput.sendKeys(money);


        WebElement monthDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" /html/body/div[1]/div/div[6]/div[3]/div/div[2]/div/div/div/div/div[1]/div/div/form/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/div")));
        monthDiv.click();
        WebElement monthInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div/div[2]/div/div/div/div/div[1]/div/div/form/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/div/div/div[2]/div/div[1]/input")));
        monthInput.click();

        monthInput.sendKeys(Keys.CONTROL + "a");
        monthInput.sendKeys(Keys.DELETE);
        monthInput.sendKeys(money);

        monthInput.sendKeys(countMonth);

        WebElement fioDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div/div[2]/div/div/div/div/div[1]/div/div/form/div[6]/div/div/span/span/div")));
        fioDiv.click();
        WebElement fioInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fio")));
        fioInput.click();
        fioInput.sendKeys(FIO);

        WebElement phoneDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div/div[2]/div/div/div/div/div[1]/div/div/form/div[7]/div[1]/div/div[1]")));
        phoneDiv.click();
        WebElement phoneMobile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone_mobile")));
        phoneMobile.sendKeys(phone);

        WebElement birthDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div/div[2]/div/div/div/div/div[1]/div/div/form/div[7]/div[2]/div/div[1]")));
        birthDiv.click();
        WebElement birthInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div/div[2]/div/div/div/div/div[1]/div/div/form/div[7]/div[2]/div/div[1]/div/div[1]/div[2]/div/div[2]/div/input")));
        birthInput.sendKeys(birthDate);
    }
    public  void  submit(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement buttonSub = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
        buttonSub.click();
    }
}
