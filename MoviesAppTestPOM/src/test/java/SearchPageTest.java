import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import pages.SearchPage;


public class SearchPageTest {
    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchPage= new SearchPage(driver);

        loginPage.LogInToApplication("rahul", "rahul@2021");
        String expedtedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(expedtedUrl));

    }

    @Test(priority = 1)
    public void SearchFunctionality() {
        searchPage.clickSearch();

        String movieNames[] = {"Venom", "Luca", "Jungle Cruise", "Narnia",
                "PAW Patrol: The Movie", "Ripper Untold",
                "Gunpowder Milkshake"};

        for (String movie : movieNames) {
            searchPage.searchForMovie(movie);

            List<WebElement> results = searchPage.getSearchResult();
            System.out.println("Search for\"" + movie + "\":" + results.size() + "movies found");

            for (WebElement result : results) {
                WebElement image = result.findElement(By.tagName("img"));
                String movieTitle = image.getAttribute("alt");
                System.out.println(" • " + movieTitle);

            }
        }
    }

    @Test(priority = 2)
    public void FailureSearchFunctionality() {
        searchPage.clickSearch();
        String movieNames[] = {"Forrest Gump", "Titanic", "Avengers"};
        for (String movie : movieNames)
        {
            searchPage.searchForMovieFailure(movie);
            System.out.println("Search for\"" + movie + "\":" + "not found");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}


