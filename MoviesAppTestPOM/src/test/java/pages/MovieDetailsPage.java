package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailsPage {

    // Movie Detail Page // web elements for all posters

    By TrendingFirstLocator = By.cssSelector(".slick-slide img");
    By TitleLocator = By.cssSelector("h1.movie-title");
    By RunTimeLocator = By.xpath("//p[@class='watch-time']");
    By SensorRatingLocator = By.xpath("//p[contains(@class, 'sensor-rating') and contains(text(), 'U/')]");
    By ReleaseTimeLocator = (By.xpath("//p[@class='release-year']"));
    By DescriptionOfMovieLocator = By.xpath("//p[contains(@class, 'movie-overview')]");

    //footer Elements
    By GeneresLocators = By.cssSelector(".genres-container .category-paragraph");
    By AudioAvailableLocators=By.cssSelector("ul.audio-container li.audio-list-item p.category-paragraph");
    By RatingCounterLocator=By.cssSelector("p.category-paragraph");
    By RatingAverageLocator= By.cssSelector("p.category-paragraph:nth-of-type(1)");;
    By BudgetLocator=By.xpath("//p[@class='category-paragraph' and contains(text(),'Crores')]");
    By ReleaseDateLocator=By.xpath("//p[@class='category-paragraph' and contains(text(),'September')]");

    By HeadingLocator=By.xpath("//h1[text()='More like this']");
    By SimilarMovieLocator=By.xpath("//ul[@class='similar-movies-list-container']//img");


    WebDriver driver;


    public MovieDetailsPage(WebDriver driver) {
        this.driver = driver;

    }

    public boolean getRunTime() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement RunTime = wait.until(ExpectedConditions.visibilityOfElementLocated(RunTimeLocator));
            return RunTime.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean getSenSorRating() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement SenSorRate = wait.until(ExpectedConditions.visibilityOfElementLocated(SensorRatingLocator));
            return SenSorRate.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean getReleasingTime() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement ReleasingTime = wait.until(ExpectedConditions.visibilityOfElementLocated(ReleaseTimeLocator));
            return ReleasingTime.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean MovieDiscription() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement MDiscription = wait.until(ExpectedConditions.visibilityOfElementLocated(DescriptionOfMovieLocator));
            MDiscription.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean footerElements() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            List<WebElement> GeneEl = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(GeneresLocators));
            if (GeneEl.size() > 0) {
                System.out.println("Geners found" + GeneEl.size());
                for (WebElement g : GeneEl) {
                    System.out.println(g.getText());
                }
                return true;
            }
            else {
                System.out.println("No genres found.");
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }


    public List<String> AudioLanguage(){
        List<WebElement> languages=driver.findElements(AudioAvailableLocators);
        List<String> AudioText= new ArrayList<>();
        for ( WebElement Audio : languages){
            AudioText.add(Audio.getText());
        }

        System.out.println(AudioText);

        return AudioText;
    }

    public boolean RatingCounter(){
        driver.findElement(RatingCounterLocator);
        return true;
    }

    public boolean RatingAverage(){
        driver.findElement(RatingAverageLocator);
        return true;
    }

    public boolean Budget(){
        driver.findElement(BudgetLocator);
        return true;
    }

    public boolean ReleaseDate(){
        driver.findElement(ReleaseDateLocator);
        return true;
    }

    public boolean getTrendingTittleLocator() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement TitleTrending = wait.until(ExpectedConditions.visibilityOfElementLocated(TitleLocator));
            return TitleTrending.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }

    }

    public String HeadingOfSimilarMovie(){
        String nameHeading=driver.findElement(HeadingLocator).getText();
        return nameHeading;
    }

    public List<String> ListOfSimilarMovies(){
        List<WebElement> MovieImages=driver.findElements(SimilarMovieLocator);
        List<String> MovieTitles=new ArrayList<>();

        for ( WebElement movie: MovieImages){
            String Title=(movie.getAttribute("alt"));
            System.out.println(Title);
            MovieTitles.add(Title);
        }
        return MovieTitles;
    }



}
