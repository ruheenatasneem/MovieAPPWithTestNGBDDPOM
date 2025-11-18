import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.AccountPage;

import java.time.Duration;


public class AccountPageTest {

    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        homePage=new HomePage(driver);
        loginPage =new LoginPage(driver);
        accountPage= new AccountPage(driver);
        loginPage.LogInToApplication("rahul","rahul@2021");
        String expectedUrl="https://qamoviesapp.ccbp.tech/";
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.urlToBe(expectedUrl));
      }

     @Test(priority = 1)
     public void TestAccountPageUiElements(){

      accountPage.clickAccount();
      Assert.assertTrue(accountPage.getAccountHeading(),"Accountheading Tested");
      Assert.assertTrue(accountPage.getMemberShipLocator(),"MemberShip Tested");
      Assert.assertTrue(accountPage.getPanDetail(),"PanDetail Tested");
      Assert.assertTrue(accountPage.getPremium(),"Premium Tested");
      Assert.assertTrue(accountPage.Username(),"UserName not exist");
      Assert.assertTrue(accountPage.PassWord(), "Password not exist" );
      Assert.assertTrue(accountPage.getUltraHD(), "Utra HD not exist");

      }
      @Test (priority = 2)
       public void LogOutFunctionality(){
          accountPage.clickAccount();
          accountPage.clickLogOut();
          String expectedUrl="https://qamoviesapp.ccbp.tech/login";
          WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.urlToBe(expectedUrl));
          String actualUrl=driver.getCurrentUrl();
          Assert.assertEquals(actualUrl,expectedUrl,"Logged out fail");

      }

     @AfterMethod
     public void tearDown(){
     driver.close();

     }
}
