package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {


    // NavBar Locators
    By imageLocator = By.cssSelector("img.website-logo[alt='website logo']");
    By homeLinkLocator = By.linkText("Home");
    By popularLinkLocator = By.linkText("Popular");

    //Navigation to pages
    By homePageNavigationLocator = By.xpath("//a[contains(@class, 'nav-link') and contains(@class, 'active-nav-link')]");
    By PopularPageNavigationLocators = By.xpath("//a[text()='Popular']");
    By accountPageNavigationLocator = By.xpath("//img[@alt='profile' and @class='avatar-img']");
    By searchBtnLocator = By.xpath("//button[@data-testid='searchButton']");

    WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;

    }

    public boolean getImageHeaderSectionDsply() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement imageIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(imageLocator));
            return imageIcon.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean getNavbarHomeHeaderSectionDsply() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement HomeNavBar = wait.until(ExpectedConditions.visibilityOfElementLocated(homeLinkLocator));
            return HomeNavBar.isDisplayed();
        } catch (TimeoutException e) {
            return false;

        }
    }

    public boolean getNavbarPopularHeaderSectionDsply() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement PopularNavBar = wait.until(ExpectedConditions.visibilityOfElementLocated(popularLinkLocator));
            return PopularNavBar.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


    public void clickHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navLink = wait.until(ExpectedConditions.visibilityOfElementLocated(homePageNavigationLocator));
        navLink.click();
        // driver.findElement(homePageNavigationLocator).click();

    }

    public void clickPopular() {
        driver.findElement(PopularPageNavigationLocators).click();
    }


    public void clickAccount()
    {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(accountPageNavigationLocator));
            profileIcon.click();
            System.out.println("Profile icon clicked successfully.");
        } catch (Exception e) {
            System.out.println("Unable to find or click profile icon: " + e.getMessage());
        }
    }

    public boolean getAccountIcon(){
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement AcntIcn = wait.until(ExpectedConditions.visibilityOfElementLocated(accountPageNavigationLocator));
            AcntIcn.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean searchIcon() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement SearIcn = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtnLocator));
            SearIcn.isDisplayed();
            return true;

        } catch (Exception e) {
            return false;
        }
    }


}
