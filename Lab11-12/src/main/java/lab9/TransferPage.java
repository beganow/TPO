package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigInteger;

public class TransferPage extends BasePage{
    public TransferPage(WebDriver driver) {
        super(driver);
    }
    public void openPage() {
        driver.get("https://www.tinkoff.ru/mybank/payments/");
    }
    public void transfer(String from, String to, String sum) {
        WebDriverWait wait = new WebDriverWait(driver, 100);



        WebElement transferCard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[3]/main/div[2]/div[2]/div[2]/div/div/div[2]/div/div[1]")));
        transferCard.click();
        WebElement transferCard12 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[3]/div/div/section/div/div/form/div[2]/div[1]/div/div/div/span/span/div/div/div[1]/div/div/div[1]/div/div")));
        transferCard12.click();

        WebElement fromCardInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"InputCard_9usAA7WxE1-cardNumber\"]")));
        fromCardInputField.sendKeys(from);

        WebElement toCardInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='InputCard_L9GAECu_IH-cardNumber']")));
        toCardInputField.sendKeys(to);

        WebElement amountInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dsId_Cj6zD_viAr']")));
        amountInputField.sendKeys(sum);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submitButton.click();

    }

    public void send() {
        WebDriverWait wait = new WebDriverWait(driver, 100); // Явное ожидание до 10 секунд
        WebElement sendBut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div/div/section/div/div/form/div[6]/div[1]/button")));
        sendBut.click();
    }
}
