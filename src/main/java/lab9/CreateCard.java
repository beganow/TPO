package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCard {
    private WebDriver driver;

    public CreateCard(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.tinkoff.ru/");
    }

    public void clickFirstButton() {
        WebElement firstButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div[2]/div/h4/a"));
        firstButton.click();
    }
    public void clickFavouriteProductsLink() {
        WebElement link = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div/ul/li[1]/div/a/span/div[1]"));
        link.click();
    }
    public boolean isOnFavouriteProductsPage() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("debit-cards"); // Предполагаем, что в URL есть "debit-cards"
    }
    public void fillForm(String fullName, String phoneNumber, String email, String birthDate) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement info = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[6]/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div/form/div[4]/div/div/span/span/div/div/div/div[1]/div[2]/div/div[2]/div/input")));
        info.click();
        info.sendKeys(fullName);

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