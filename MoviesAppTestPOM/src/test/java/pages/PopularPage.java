package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PopularPage {

    //Similar Container Movies
    By HeadingLocator=By.xpath("//h1[text()='More like this']");
    By SimilarMovieLocator=By.xpath("//ul[@class='similar-movies-list-container']//img");
    By PopularPageNavigationLocators = By.xpath("//a[text()='Popular']");
    By searchBtnLocator = By.xpath("//button[@data-testid='searchButton']");

    WebDriver driver;


    public PopularPage(WebDriver driver) {
        this.driver = driver;

    }

    public void clickPopular() {
        driver.findElement(PopularPageNavigationLocators).click();
    }

    public void clickSearch() {
        driver.findElement(searchBtnLocator).click();
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
