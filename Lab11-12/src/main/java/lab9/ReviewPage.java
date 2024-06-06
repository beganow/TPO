package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage extends BasePage {
    public ReviewPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement reviews = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div[1]/div/div/div/div/div[2]/div/nav/span[3]/a")));
        reviews.click();
    }
    public void fillReview(String fio, String phone, String mail, String city, String review) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement fioreview = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[1]/div/div/span/span/div/div/div")));
        fioreview.click();
        WebElement fioreviewinput = driver.findElement(By.xpath("/html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[1]/div/div/span/span/div/div/div/div/div/div/div[2]/div/input"));
        fioreviewinput.sendKeys(fio);
        WebElement phonereview =  driver.findElement(By.xpath("/html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[2]/div[1]/div/div[1]/div"));
        phonereview.click();
        WebElement phonereviewinput =  driver.findElement(By.xpath("/html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[2]/div[1]/div/div[1]/div/div/div/div/div[2]/div/input"));
        phonereviewinput.sendKeys(phone);
        WebElement mailreview =  driver.findElement(By.xpath("  /html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[2]/div[2]/div/span/span/div/div/div"));
        mailreview.click();
        WebElement mailreviewinput =  driver.findElement(By.xpath("/html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[2]/div[2]/div/span/span/div/div/div/div/div/div/div[2]/div/input"));
        mailreviewinput.sendKeys(mail);
        WebElement cityreview=  driver.findElement(By.xpath("/html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[3]/div/div/div[1]/div"));
        cityreview.click();
        WebElement cityreviewinput=  driver.findElement(By.xpath("/html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[3]/div/div/div[1]/div/div/div/div/div[2]/div/input"));
        cityreviewinput.sendKeys(city);
        WebElement textreview=  driver.findElement(By.xpath("/html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[5]/div/div/div[1]/div"));
        textreview.click();
        WebElement textreviewinput=  driver.findElement(By.xpath("/html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[5]/div/div/div[1]/div/div[1]/div/div/div/div[2]/textarea"));
        textreviewinput.sendKeys(review);
    }
    public void submit(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement buttinsub = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" /html/body/div[1]/div/div[12]/div[2]/div/div/div/div/div/div/div/div/div/form/div[7]/div[2]/div/div[1]/button")));
        buttinsub.click();
    }
}
