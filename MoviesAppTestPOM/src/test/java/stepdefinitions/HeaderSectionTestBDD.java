package stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HeaderSectionPageBDD;
import pages.HomePageBDD;
import pages.LoginPageBDD;

import java.time.Duration;

public class HeaderSectionTestBDD {
    WebDriver driver;
    HeaderSectionPageBDD headerSectionPageBDD;
    LoginPageBDD loginPageBDD;
    HomePageBDD homePageBDD;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://qamoviesapp.ccbp.tech/login");

        loginPageBDD = new LoginPageBDD(driver);
        homePageBDD = new HomePageBDD(driver);
        headerSectionPageBDD= new HeaderSectionPageBDD(driver);

        loginPageBDD.enterUserName("rahul");
        loginPageBDD.enterPassWord("rahul@2021");
        loginPageBDD.clickLoginButton();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

    }

    @Given("I am on Home Page")
    public void  headerSectionTest() {

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,"Url not matched");
    }

    @When("Test whether the Website logo is displayed")
    public void headerLogoDisplayed(){
        Assert.assertTrue(headerSectionPageBDD.isLogoDsply(),"Logo not displayed");
    }

    @And("Test the Navbar elements")
    public void headerNavbarElement(){
        Assert.assertTrue(headerSectionPageBDD.isHomeNavDsply(),"Navbar Home not displayed");
        Assert.assertTrue(headerSectionPageBDD.isPopularNavDsply(),"Navbar Popular not dispayed");

    }

    @When("Navigation to Home and Popular pages")
    public void fromNavbarNavigationHomePopular(){

        String expectedHomeUrl="https://qamoviesapp.ccbp.tech/";
        String actualHomeUrl=headerSectionPageBDD.clickHomePage();

        Assert.assertEquals(expectedHomeUrl,actualHomeUrl ,"Home page does not match");

        String expectedPopularUrl="https://qamoviesapp.ccbp.tech/popular";
        String actualPopularUrl=headerSectionPageBDD.clickPopularPage();

        Assert.assertEquals(expectedPopularUrl, actualPopularUrl, "Popular page does not match");
    }

    @And("Navigation to account page")
    public void fromNavbarNavigationAccount(){
        String expectedAccountUrl="https://qamoviesapp.ccbp.tech/account";
        String actualAccountUrl=headerSectionPageBDD.clickAccountPage();
        Assert.assertEquals(expectedAccountUrl,actualAccountUrl,"Account page does not match");
    }


    @Then("Close the browser window")
    public void tearDown() {

        driver.quit();

    }

}
