import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import java.time.Duration;
import pages.LoginPage;



public class LogInPageTest {

    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver= new ChromeDriver();
         driver.get("https://qamoviesapp.ccbp.tech/login");
         loginPage =new LoginPage(driver);

    }

    @Test(priority = 0)
    public void testLogInPageUI(){
        Assert.assertTrue(loginPage.FindLogInImage().isDisplayed(),"Image not displayed");
        Assert.assertEquals(loginPage.getLabelTextAt(0),"USERNAME","User name not matched");
        Assert.assertEquals(loginPage.getLabelTextAt(1),"PASSWORD", "Password not mached");

        String expectedHeading="Login";
        String actualHeading=loginPage.getLogInHeadingText();
        Assert.assertEquals(actualHeading,expectedHeading ,"Heading text not matched");
    }


    @Test(priority = 1)
    public void testLogInPageWithEmptyInputs(){
        loginPage.clickButton();
        String errorMsg="*Username or password is invalid";
        String  actualErrorMsg=loginPage.geErrorMsgLocator();
        Assert.assertEquals(actualErrorMsg, errorMsg, "*Username or password is invalid");
    }


    @Test(priority = 2)
    public void testLogInWithEmptyUserName(){
        loginPage.LogInToApplication("","rahul@2021");
        String actualErrorMsg=loginPage.geErrorMsgLocator();
        Assert.assertEquals(actualErrorMsg,"*Username or password is invalid","Error Text with invalid username and password");
    }

    @Test(priority = 3)
    public void testLogInPageWithEmptyPassWord(){
        loginPage.LogInToApplication("rahul","");
        String actualErrorMsg=loginPage.geErrorMsgLocator();
        Assert.assertEquals(actualErrorMsg,"*Username or password is invalid","Error Text with invalid username and password");
    }

    @Test(priority = 4)
    public void testLogInPageWithInvalidCredentials(){
        loginPage.LogInToApplication("rahul","rahul@2025");
        String actualErrorMsg=loginPage.geErrorMsgLocator();
        Assert.assertEquals(actualErrorMsg,"*username and password didn't match","Error Text with invalid username and password");
    }


    @Test(priority = 5)
    public void testLogInPageWithValidCredentials(){
        loginPage.LogInToApplication("rahul","rahul@2021");
        String expectedUrl="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
