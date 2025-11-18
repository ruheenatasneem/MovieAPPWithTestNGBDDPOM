package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;


public class HomePage {

    //Heading Locators
    By TrendingHeadingLocators = By.xpath("//h1[text()='Trending Now']");
    By OriginalHeadingLocators = By.xpath("//h1[text()='Originals']");
    By PlayBtnLocator = By.xpath("//button[contains(text(), 'Play')]");

    //Locators (slicker)
    By MovieLinkLocator = By.cssSelector(".slick-slide a.link-item");
    By ActiveSideLocator = By.cssSelector(".slick-slide.slick-active");
    By PosterImageLocator = By.cssSelector(".slick-slide img.poster");
    By DunePosterLocator = By.xpath("//img[@alt='Dune']");
    By SlideIndexThreeLocator = By.cssSelector("div[data-index='0']");

    //Locators (button)
    By PrevoiusButtonLocator = By.cssSelector("button.slick-prev");

    // Movies Locators
    By trendingMoviesLocator = By.xpath("//h1[text()='Trending Now']/following-sibling::div//img");
    By originalMoviesLocator = By.xpath("//h1[text()='Originals']/following-sibling::div//img");
    By googleContactUsLocator = By.cssSelector("svg.google-icon");
    By twitterContactUsLocator = By.cssSelector("svg.twitter-icon");
    By intaGramContactUsLocator = By.cssSelector("svg.instagram-icon");
    By youTubeContactUsLocator = By.cssSelector("svg.youtube-icon");

     //Navigation to pages
    By homePageNavigationLocator = By.xpath("//a[contains(@class, 'nav-link') and contains(@class, 'active-nav-link')]");


    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }


    public String getIsTrendingHeading() {
        return driver.findElement(TrendingHeadingLocators).getText();
    }


    public String getIsOriginalHeading() {
        return driver.findElement(OriginalHeadingLocators).getText();
    }

    public Boolean IsPlayButtonDisplay() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(PlayBtnLocator));
            return playButton.isDisplayed();
        } catch (
                TimeoutException e) {
            System.out.println("Play button not found in time: " + e.getMessage());
            return false;
        } catch (
                NoSuchElementException e) {
            System.out.println("Play button not found: " + e.getMessage());
            return false;
        }

    }

    public boolean getTrendingMoviesDsply() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {

            WebElement trending = wait.until(ExpectedConditions.visibilityOfElementLocated(trendingMoviesLocator));
            return trending.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }

    }

    public boolean getOriginalMoviesDsply() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement original = wait.until(ExpectedConditions.visibilityOfElementLocated(originalMoviesLocator));
            return original.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


    public boolean getGoogleContactUsDsply() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement googleIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(googleContactUsLocator));
            return googleIcon.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean getTwitterContactUsDsply() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement twitterIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(twitterContactUsLocator));
            return twitterIcon.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean getInstagramContactUsDsply() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement instagramIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(intaGramContactUsLocator));
            return instagramIcon.isDisplayed();
        } catch (TimeoutException e) {
            return false;

        }
    }

    public boolean getYouTubeContactUsDsply() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement youTubeIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(youTubeContactUsLocator));
            return youTubeIcon.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }



    public void clickHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navLink = wait.until(ExpectedConditions.visibilityOfElementLocated(homePageNavigationLocator));
        navLink.click();

    }

    public int getMovieLinkCount() {
        List<WebElement> movieLinks = driver.findElements(MovieLinkLocator);
        return movieLinks.size();
    }

    public int getActiveSlideCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> activeSlides = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(ActiveSideLocator));
        return activeSlides.size();
    }

    public void printPosterTitles() {
        List<WebElement> posterImages = driver.findElements(PosterImageLocator);
        for (WebElement poster : posterImages) {
            System.out.println("- " + poster.getAttribute("alt"));
        }
    }

    public boolean isDunePosterVisible() {
        try {
            WebElement dunePoster = driver.findElement(DunePosterLocator);
            return dunePoster.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isSlideIndexThreeVisible() {
        try {
            WebElement slideIndexThree = driver.findElement(SlideIndexThreeLocator);
            return slideIndexThree.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean PreviousButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".slick-track")));
            WebElement PreBtn = driver.findElement(PrevoiusButtonLocator);
            PreBtn.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(
            By.cssSelector(".slick-slide.slick-current[aria-hidden='false']")));

            // Get the current visible movie poster
            WebElement currentSlideImage = driver.findElement(
            By.cssSelector(".slick-slide.slick-current[aria-hidden='false'] img.poster"));

            // Print the alt text of the new visible movie (movie title)
            String movieTitle = currentSlideImage.getAttribute("alt");
            System.out.println("Currently visible movie: " + movieTitle);
            return movieTitle != null && !movieTitle.isEmpty();

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

   }













