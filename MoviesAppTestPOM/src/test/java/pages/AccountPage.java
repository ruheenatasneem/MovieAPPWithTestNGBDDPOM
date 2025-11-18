package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {


    // AccountPage

    By AccountHeadingLocators = By.xpath("//h1[@class='account-heading']");
    By MemberShipLocator = By.xpath("//p[@class='membership-heading' and normalize-space(text())='Member ship']");
    By UserNameLocator=By.cssSelector("p.membership-username");
    By PasswordLocator=By.xpath("//p[@class='membership-password']");

    By PanDetailsLocator = By.xpath("//p[@class='membership-heading' and normalize-space(text())='Plan details']");
    By PremiumLocator = By.xpath("//p[@class='plan-paragraph' and normalize-space(text())='Premium']");
    By UltraHD=By.xpath("//p[@class='plan-details' and normalize-space(text())='Ultra HD']");

    // LogOut Function
    By LogOutButtonLocator = By.className("logout-button");

    //Navigation to account page
    By accountPageNavigationLocator = By.xpath("//img[@alt='profile' and @class='avatar-img']");
    By searchBtnLocator = By.xpath("//button[@data-testid='searchButton']");
    WebDriver driver;


    public AccountPage(WebDriver driver) {
      this.driver = driver;

    }

    public boolean getMemberShipLocator() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement MemberShip = wait.until(ExpectedConditions.visibilityOfElementLocated(MemberShipLocator));
            return MemberShip.isDisplayed();

        } catch (Exception e) {
            return false;
        }
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

    public boolean getAccountHeading() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement AccountHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(AccountHeadingLocators));
            return AccountHeading.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }


    public boolean getPanDetail() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement PanDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(PanDetailsLocator));
            return PanDetail.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }


    public boolean getPremium() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement Premium = wait.until(ExpectedConditions.visibilityOfElementLocated(PremiumLocator));
            return Premium.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogOut() {
        driver.findElement(LogOutButtonLocator).click();

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

    public boolean getUltraHD(){
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement AcntIcn = wait.until(ExpectedConditions.visibilityOfElementLocated(UltraHD));
            AcntIcn.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
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


    public boolean Username(){
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement nameUser=driver.findElement(UserNameLocator);
            nameUser.isDisplayed();
            return true;

        }
        catch(Exception e){
            return false;
        }
    }

    public boolean PassWord(){
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement nameUser=driver.findElement(PasswordLocator);
            nameUser.isDisplayed();
            return true;

        }
        catch(Exception e){
            return false;
        }
    }


}
