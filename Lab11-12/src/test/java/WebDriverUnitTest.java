import lab9.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

import lab9.CreateCardPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class WebDriverUnitTest {
    private WebDriver driver;
    private BrowserManager browserManager;
    private HomePage tinkoffHomePage;
    private CreateCardPage createCardPage;
    private  CreditPage creditPage;
    private DepositPage depositPage;
    private ReviewPage reviewPage;
    private BankomatsPage bankomantsPage;
    private TransferPage transferPage;
    private ShopPage shopPage;

    @Before
    public void setUp() {
        browserManager = new BrowserManager();
        driver = browserManager.initializeDriver();
        tinkoffHomePage = new HomePage(driver);
        createCardPage = new CreateCardPage(driver);
        creditPage = new CreditPage(driver);
        depositPage = new DepositPage(driver);
        reviewPage = new ReviewPage(driver);
        bankomantsPage = new BankomatsPage(driver);
        transferPage = new TransferPage(driver);
        shopPage = new ShopPage(driver);
    }

    @Test
    public void testCreateCard() {
        tinkoffHomePage.open();
        tinkoffHomePage.clickFirstButton();
        createCardPage.fillForm("Павел Ободов Андреевич", "9212345677", "pashok12obodov@gmail.com", "01032004");
        createCardPage.submitForm();
    }
    @Test
    public void testDebit() {
        tinkoffHomePage.open();
        createCardPage.clickFavouriteProductsLink();
        createCardPage.isOnFavouriteProductsPage();
    }
    @Test
    public void сreateCredit(){
        tinkoffHomePage.open();
        tinkoffHomePage.credits();
        creditPage.calcCredit("1000000", "2", "Ободов Павел Андреевич" , "9212345677");
        creditPage.submit();
   }

    @Test
    public void searchCard(){
        tinkoffHomePage.open();
        tinkoffHomePage.sfq("Карты");
    }
    @Test
    public void searchTransfer(){
        tinkoffHomePage.open();
        tinkoffHomePage.sfq("!/ЪВ!Переводы");
    }
    @Test
    public void auth(){
        tinkoffHomePage.open();
        tinkoffHomePage.profile();
        //tinkoffHomePage.fillphone("375445425233");
    }
    @Test
    public void createDeposit(){
    tinkoffHomePage.open();
    tinkoffHomePage.deposits();
    depositPage.open();
    depositPage.info("1000000", "5", "Струнин Игорь Филатович", "9212345677", "01032004");
    depositPage.submit();
    }

    @Test
    public void review(){
        tinkoffHomePage.open();
        tinkoffHomePage.reviews();
        reviewPage.open();
        reviewPage.fillReview("Ободов Павел Андреевич", "9212345677", "fewhfewhe@gmail.com", "SPB", "Заказала карту, очень понравилась. Комиссии маленькие, доставили быстро. Советую всем знакомым и друзьям.");
        reviewPage.submit();
    }
    @Test
    public void bankomats (){
        tinkoffHomePage.open();
        bankomantsPage.openPage();
        bankomantsPage.fillsum("9000000");
    }
    @Test
    public void transfer(){
        tinkoffHomePage.open();
        transferPage.openPage();
        //transferPage.transfer("222222222222222", "222222222222222", "10");
    }

    @Test
    public void shop(){
        tinkoffHomePage.open();
        shopPage.goToShopPage();
        shopPage.getHoodi();
        shopPage.delFromBusk();
    }


    @After
    public void tearDown() {
        browserManager.quitDriver();
    }
}