package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.tinkoff.ru/");
    }

    public void clickFirstButton() {
        WebElement firstButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div/div/div[2]/div"));
        firstButton.click();

    }
    public void profile(){
        WebElement profileButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/nav/div[2]"));
        profileButton.click();
        WebElement bankButton =  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/nav/div[2]/div/div/ul/li[1]/div/div/a/span/div"));
        bankButton.click();
        try {
            Thread.sleep(10000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void credits(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement credits = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div/div/ul/li[3]/div/a/span/div[1]")));
        credits.click();
    }
    public void deposits(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement credits = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div/div/ul/li[5]/div")));
        credits.click();
    }
    public void sfq(String word){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement searchDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[21]/div/div/div/div[1]/span/span/div/div/div/div[2]")));
        searchDiv.click();
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[21]/div/div/div/div[1]/span/span/div/div/div/div[2]/div/div/div[2]/div/input")));
        searchInput.click();
        searchInput.sendKeys(word);
        try {
            Thread.sleep(1000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void reviews(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement reviewDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/footer/div[1]/div/div/nav/ul/li[3]/div/div/div[2]/ul/li[6]/a")));
        reviewDiv.click();
    }

    /* public void fillphone(String phone){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._Input_27y5o_15")));
       phoneInput.sendKeys(phone);

    }*/
    public void other(){
       driver.get("https://www.tinkoff.ru/maps/atm/");
    }

}