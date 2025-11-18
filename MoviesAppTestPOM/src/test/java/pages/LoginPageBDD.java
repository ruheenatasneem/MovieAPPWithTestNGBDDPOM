package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageBDD {
    WebDriver driver;
    WebDriverWait wait;

    private static final String BASE_URL = "https://qamoviesapp.ccbp.tech/login";


    //Define the locators

    @FindBy(how = How.CLASS_NAME, using = "login-website-logo")
    WebElement LogoLocator;

    @FindBy(how = How.CLASS_NAME, using ="sign-in-heading")
    WebElement LoginHeadingLocator;

    @FindBy(how = How.ID, using ="usernameInput")
    @CacheLookup
    WebElement UserNameInputLocator;

    @FindBy(how = How.ID, using ="passwordInput")
    @CacheLookup
    WebElement PassWordLocator;

    @FindBy(how = How.CLASS_NAME, using ="login-button")
    WebElement LoginButtonLocator;

    @FindBy(how = How.CSS, using =".error-message")
    WebElement ErrorMsgLocator;


    // Constructor :Initialige the POM elements

    public LoginPageBDD(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // Page action
    public String navigateToLogInPage() {
        driver.get(BASE_URL);
        return driver.getCurrentUrl();
    }

    public boolean findLogInImage() {

        try {
            WebElement logo = wait.until(ExpectedConditions.visibilityOf(LogoLocator));
            return logo.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }


    public String getLoginHeadingText() {
        wait.until(ExpectedConditions.visibilityOf(LoginHeadingLocator));
        return LoginHeadingLocator.getText();

    }


    public void enterUserName(String UsrName){
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(UserNameInputLocator));
        UserNameInputLocator.clear();
        UserNameInputLocator.sendKeys(UsrName);
    }

    public void enterPassWord(String PassWord){
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(PassWordLocator));
        PassWordLocator.clear();
        PassWordLocator.sendKeys(PassWord);
    }

    public boolean clickLoginButton() {
        try {
            LoginButtonLocator.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(ErrorMsgLocator));
        return ErrorMsgLocator.getText();
    }

}
