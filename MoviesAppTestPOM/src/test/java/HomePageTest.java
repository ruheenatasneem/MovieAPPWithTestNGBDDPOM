import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import pages.LoginPage;
import pages.HomePage;


public class HomePageTest {

    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.LogInToApplication("rahul", "rahul@2021");
        String expedtedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expedtedUrl));
    }

    @Test(priority = 1)
    public void TestHomePageHeading() {
        String actualTrendingHeading = homePage.getIsTrendingHeading();
        String expedtedTrendingHeading = "Trending Now";

        Assert.assertEquals(expedtedTrendingHeading, actualTrendingHeading, "Heading Trending doesnot matched");

        String actualOriginalHeading = homePage.getIsOriginalHeading();
        String expectedOriginalHeading = "Originals";

        Assert.assertEquals(expectedOriginalHeading, actualOriginalHeading, "Heading Originals doesnot matched");

        Assert.assertTrue(homePage.IsPlayButtonDisplay(), "Play button is disabled");

    }

    @Test(priority = 2)

    public void testTrendingAndOriginalMoviesDisplayed() {
        Assert.assertTrue(homePage.getTrendingMoviesDsply(), "Trending movies should be displayed");
        Assert.assertTrue(homePage.getOriginalMoviesDsply(), "Original movies should be displayed");
    }

    @Test(priority = 3)
    public void testContactUsDisplayed(){
        Assert.assertTrue(homePage.getGoogleContactUsDsply(),"Google icon dispalyed");
        Assert.assertTrue(homePage.getTwitterContactUsDsply(),"Twitter icon displayed");
        Assert.assertTrue(homePage.getInstagramContactUsDsply(),"Instagram icon displayed");
        Assert.assertTrue(homePage.getYouTubeContactUsDsply(),"Youtube icon displayed");
    }
   @Test(priority =4 )
    public void MovieTestFunctionalityLinkCount() {
        int expectedCount = 20;
        Assert.assertEquals(homePage.getMovieLinkCount(), expectedCount, "Movie link count mismatch");

    }

    @Test(priority = 5)
    public void MovieTestActiveSlideCount() {
        int actualSlideCount= homePage.getActiveSlideCount();
        Assert.assertTrue((actualSlideCount == 8 || actualSlideCount== 4), "Movie slide count mismatch");

    }

    @Test(priority = 6)
    public void MovieTestPrintPosterTest() {
        homePage.printPosterTitles();
    }


    @Test(priority = 7)
    public void MovieTestIsDunePosterVisible() {
        Assert.assertTrue(homePage.isDunePosterVisible(), "IsDune Poster Visible Failed");
    }

    @Test(priority = 8)
    public void MovieTestisSlideIndexThreeVisible() {
        Assert.assertTrue(homePage.isSlideIndexThreeVisible(),"Slide Index not visible");
    }

    @Test(priority = 9)
    public void Buttonclick(){
        Assert.assertTrue(homePage.PreviousButton(),"Not Displayed");

    }

    @AfterMethod
    public void tearDown(){
      driver.close();
    }

}
