package lab9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CreateCardPage extends BasePage {
    public CreateCardPage(WebDriver driver) {
        super(driver);
    }

    public void clickFavouriteProductsLink() {
        WebDriverWait wait = new WebDriverWait(driver, 100); // Явное ожидание до 10 секунд
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div/div/ul/li[1]/div/a/span/div[1]")));
        link.click();

    }

    public boolean isOnFavouriteProductsPage() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("debit-cards");
    }

    public void fillForm(String fullName, String phoneNumber, String email, String birthDate) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement info = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[4]/div/div/span/span/div/div/div")));
        info.click();
        WebElement info1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[4]/div/div/span/span/div/div/div/div[1]/div[2]/div/div[2]/div/input"));
        info1.sendKeys(fullName);

        WebElement phone = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[5]/div[1]/div/div[1]/div/div[1]/div[2]/div/div[2]/div/input"));
        phone.click();
        phone.sendKeys(phoneNumber);

        WebElement mail = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[5]/div[2]/div/span/span/div/div/div/div/div[2]/div/div[2]/div/input"));
        mail.click();
        mail.sendKeys(email);

        WebElement birth = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[6]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/input"));
        birth.click();
        birth.sendKeys(birthDate);
    }

    public void submitForm() {
        WebElement send = driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[9]/div[2]/div/div[1]/button"));
        send.click();
    }
}