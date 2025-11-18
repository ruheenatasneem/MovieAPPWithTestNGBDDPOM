package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePageBDD;
import pages.LoginPageBDD;

import java.time.Duration;

public class HomeTestBDD {

    WebDriver driver;
    HomePageBDD homePageBDD;
    LoginPageBDD loginPageBDD;

    @Before
    public void  setUp(){

        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");

        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/");
        loginPageBDD = new LoginPageBDD(driver);
        homePageBDD = new HomePageBDD(driver);

        loginPageBDD.enterUserName("rahul");
        loginPageBDD.enterPassWord("rahul@2021");
        loginPageBDD.clickLoginButton();

        String expedtedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expedtedUrl));

    }

    @Given("I am on home page")
    public void testHomePage(){
        String  expectedUrl="https://qamoviesapp.ccbp.tech/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Url not matched");
    }

    @When("Test heading texts of each section")
    public void testHeading(){
        String expectedHeading="Trending Now";
        Assert.assertEquals(expectedHeading,homePageBDD.trendingHeading(),"Heading not matched");

        String expectedHeadingOrig="Originals";
        Assert.assertEquals(expectedHeadingOrig,homePageBDD.originalHeading(),"Heading not matched");

    }

    @And("Test play button is displayed or not")
    public void playButton(){
        Assert.assertTrue(homePageBDD.isPlayButtonDisplay(),"Disable Play button not exsit");
    }

    @And("Test Movies are displayed,in corresponding movies sections")
    public void MoviesDisplayed(){
        Assert.assertTrue(homePageBDD.getTrendingMoviesDsply(),"Trending movie not displayed");
        Assert.assertTrue(homePageBDD.getOriginalMoviesDsply(),"Original movie not displayed");

    }

    @Then("Test Contact Us Section")
    public void ContactSection(){
        Assert.assertTrue(homePageBDD.getGoogleContactUsDsply(),"Google Contact not displayed");
        Assert.assertTrue(homePageBDD.getTwitterContactUsDsply(),"Twitter contact not displayed");
        Assert.assertTrue(homePageBDD.getInstagramContactUsDsply(),"Instagram contact not displayed");
        Assert.assertTrue(homePageBDD.getYouTubeContactUsDsply(),"YouTube display not exist");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}




