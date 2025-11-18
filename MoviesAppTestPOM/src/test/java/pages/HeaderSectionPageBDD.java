package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderSectionPageBDD {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy (css ="img.website-logo[alt='website logo']" )
    WebElement imageLocator;

    @FindBy (linkText="Home")
    WebElement homeLinkLocator;

    @FindBy (linkText="Popular")
    WebElement popularLinkLocator;

    @FindBy (xpath ="//a[contains(@class, 'nav-link') and contains(@class, 'active-nav-link')]")
    WebElement homePageNavigationLocator;

    @FindBy (xpath ="//a[text()='Popular']")
    WebElement popularPageNavigationLocators;

    @FindBy (xpath="//img[@alt='profile']")
    WebElement accountPageNavigationLocator;




    public HeaderSectionPageBDD(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }



    public boolean isLogoDsply() {
        try {

            return wait.until(ExpectedConditions.visibilityOf(imageLocator)).isDisplayed();

        }catch(Exception e){
            return false;
        }

    }

    public boolean isHomeNavDsply() {
        try {

            return wait.until(ExpectedConditions.visibilityOf(homeLinkLocator)) .isDisplayed();

        } catch (TimeoutException e) {
            return false;

        }
    }

    public boolean isPopularNavDsply() {
        try{

            return wait.until(ExpectedConditions.visibilityOf(popularLinkLocator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String clickHomePage() {
        String expectedHomeUrl="https://qamoviesapp.ccbp.tech/";
        homePageNavigationLocator.click();
        wait.until(ExpectedConditions.urlToBe(expectedHomeUrl));
        return driver.getCurrentUrl();

    }

    public String clickPopularPage() {
        String expectedPopularUrl="https://qamoviesapp.ccbp.tech/popular";
        popularPageNavigationLocators.click();
        wait.until(ExpectedConditions.urlToBe(expectedPopularUrl));
        return driver.getCurrentUrl();
    }

    public String clickAccountPage() {
        String expextedAccountUrl="https://qamoviesapp.ccbp.tech/account";
        accountPageNavigationLocator.click();
        wait.until(ExpectedConditions.urlToBe(expextedAccountUrl));
        return driver.getCurrentUrl();
    }
}



