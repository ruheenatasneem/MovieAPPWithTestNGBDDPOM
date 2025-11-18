package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    // Search Page
    By inputSearchLocator = By.id("search");
    By searchPageLocator = By.cssSelector("button[data-testid='searchButton']");
    By movieTilesLocator = By.xpath("//a[contains(@class,'link-item')]");
    By searchBtnLocator = By.xpath("//button[@data-testid='searchButton']");

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;

    }

    public void clickSearch()
    {
       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
       WebElement searchButton=wait.until(ExpectedConditions.elementToBeClickable(searchBtnLocator));
       searchButton.click();

    }

    public void searchForMovie(String movieName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchLocator));
        input.clear();
        input.sendKeys(movieName);
        driver.findElement(searchBtnLocator).click();
    }

    public List<WebElement> getSearchResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTilesLocator));
        return driver.findElements(movieTilesLocator);


    }


    public void searchForMovieFailure(String movieName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchLocator));
        input.clear();
        input.sendKeys(movieName);
        driver.findElement(searchPageLocator).click();
    }


}
