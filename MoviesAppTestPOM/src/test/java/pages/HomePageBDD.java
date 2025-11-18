package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageBDD {

    WebDriver driver;
    WebDriverWait wait;


    //Heading Locators
    @FindBy (xpath="//h1[text()='Trending Now']")
    WebElement trendingHeadingLocators;

    @FindBy(xpath ="//h1[text()='Originals']")
    WebElement OriginalHeadingLocators;

    @FindBy(xpath="//button[contains(text(), 'Play')]")
    WebElement playBtnLocator;

    @FindBy(css ="svg.google-icon" )
    WebElement googleContactUsLocator;

    @FindBy(css ="svg.twitter-icon" )
    WebElement  twitterContactUsLocator;

    @FindBy(css="svg.instagram-icon")
    WebElement intaGramContactUsLocator;

    @FindBy(css="svg.youtube-icon")
    WebElement youTubeContactUsLocator;

    @FindBy(xpath="//h1[text()='Trending Now']/following-sibling::div//img")
    WebElement trendingMoviesLocator;

    @FindBy(xpath ="//h1[text()='Originals']/following-sibling::div//img")
    WebElement originalMoviesLocator;

    // Constructor initialization to POM
    public HomePageBDD(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }

    public String trendingHeading(){
        return trendingHeadingLocators.getText();
    }

    public String originalHeading(){
        return OriginalHeadingLocators.getText();
    }

    public Boolean isPlayButtonDisplay() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(playBtnLocator));
            return playBtnLocator.isDisplayed();
        } catch (TimeoutException e){
            System.out.println("Play button not found in time: " + e.getMessage());
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("Play button not found: " + e.getMessage());
            return false;
        }

    }

    public boolean getTrendingMoviesDsply() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOf(trendingMoviesLocator));
            return trendingHeadingLocators.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }

    }

    public boolean getOriginalMoviesDsply() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOf(originalMoviesLocator));
            return originalMoviesLocator.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean getGoogleContactUsDsply() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(googleContactUsLocator));
            return googleContactUsLocator.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean getTwitterContactUsDsply() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(twitterContactUsLocator));
            return twitterContactUsLocator.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean getInstagramContactUsDsply() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(intaGramContactUsLocator));
            return intaGramContactUsLocator.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean getYouTubeContactUsDsply() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(youTubeContactUsLocator));
            return youTubeContactUsLocator.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }




}
