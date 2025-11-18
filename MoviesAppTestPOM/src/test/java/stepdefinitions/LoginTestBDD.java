package stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import pages.LoginPageBDD;

import java.time.Duration;


public class LoginTestBDD {
    WebDriver driver;

    LoginPageBDD loginPageBDD;


    @Before
    public void setUP() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPageBDD = new LoginPageBDD(driver);

    }

    @Given("I am on login page")
    public void IamOnLogInPage() {
        String actualUrl= loginPageBDD.navigateToLogInPage();
        String expectedUrl ="https://qamoviesapp.ccbp.tech/login";
        Assert.assertEquals(actualUrl, expectedUrl, "Url not displayed");
        Assert.assertTrue(loginPageBDD.findLogInImage(),"Logo not exist");
        String expectedHeading="Login";
        Assert.assertEquals(loginPageBDD.getLoginHeadingText(),expectedHeading,"Heading not found");

    }

    @When("I enter valid username and password")
    public void validUsenamePassword(){
        loginPageBDD.enterUserName("rahul");
        loginPageBDD.enterPassWord("rahul@2021");
    }

    @When ("I enter invalid username and password")
    public void invalidnamepassword(){
        loginPageBDD.enterUserName("rahul");
        loginPageBDD.enterPassWord("rahul@2024");
    }


    @And("I clicked on login button")
    public void clickLoginButton(){
        Assert.assertTrue(loginPageBDD.clickLoginButton(),"Not clicked login button");
    }

    @Then("Successfully redirected to Home page")
    public void redirectHomePage(){

        String exprctedUrl="https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(exprctedUrl));
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, exprctedUrl,"Url not found");

    }

    @Then("Displaying error message")
    public void errorMessage(){
        String expectedError="*username and password didn't match";
        Assert.assertEquals(loginPageBDD.getErrorMessage(),expectedError,"Error message not displayed");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}




