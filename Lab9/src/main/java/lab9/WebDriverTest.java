package lab9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Загрузки\\webdriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tinkoff.ru/");


        WebElement firstButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div/div/div[2]/div/h4/a"));
        firstButton.click();
        Thread.sleep(2000); // Пауза для ожидания загрузки


        WebElement info = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/div[1]/div/div/form/div[4]/div/div/span/span/div/div/div/div[1]/div[2]/div/div[2]/div/input"));
        info.click();
        info.sendKeys("Павел Ободов Андреевич");


        WebElement phone = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/div[1]/div/div/form/div[5]/div[1]/div/div[1]/div/div[1]/div[2]/div/div[2]/div/input"));
        phone.click();
        phone.sendKeys("9211234567");

        WebElement birthdate = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/div[1]/div/div/form/div[6]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/input"));
        birthdate.click();
        phone.sendKeys("01.01.1990");

        WebElement citizen = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/div[1]/div/div/form/div[7]/div/div/div[2]/div/div/div/label[2]/span/div[2]/span/input"));
        citizen.click();

        WebElement send = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/div[1]/div/div/form/div[11]/div[2]/div/div[1]/button"));
        send.click();

        Thread.sleep(5000);

        driver.quit(); // Закрываем браузер
    }
}
