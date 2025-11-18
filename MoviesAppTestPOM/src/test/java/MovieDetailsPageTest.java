import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MovieDetailsPage;

import java.util.Arrays;
import java.util.List;

import java.time.Duration;


public class MovieDetailsPageTest {

    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    MovieDetailsPage movieDetailsPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        movieDetailsPage=new MovieDetailsPage(driver);

        loginPage.LogInToApplication("rahul", "rahul@2021");
        String expedtedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expedtedUrl));

    }

    @Test(priority = 1)
    public void TestMovieDetailPage() {

        homePage.clickHomePage();

    }

    // Loading first movie from Trending

    @Test(priority = 2)
    public void TestMovieDetailCategoriesContainer() {
       try {

          List<WebElement> movies = driver.findElements(By.cssSelector(".slick-slide img"));
            if (movies.size() > 0) {
               movies.get(0).click();

            } else {
                System.out.println("Movies are not found");
                return;
            }

            // Movie Title
          Assert.assertTrue(movieDetailsPage.getTrendingTittleLocator(), "Title Not displayed");
          Assert.assertTrue(movieDetailsPage.getRunTime(), "Run time not displayed");
          Assert.assertTrue(movieDetailsPage.getSenSorRating(), "Sensor rating not displayed");
          Assert.assertTrue(movieDetailsPage.getReleasingTime(), "Releasing time not displayed");
          Assert.assertTrue(movieDetailsPage.MovieDiscription(), "Movie Description not displayed");
          // Assert.assertTrue(homePage.footerElements(),"Genere Elements not displayed");
        } catch (Exception e) {
            System.out.println("Error");

        }
    }


    @Test(priority = 3)
    public void footerContainer () {

     try {
       List<WebElement> movies = driver.findElements(By.cssSelector(".slick-slide img"));
           if (movies.size() > 0) {
                 movies.get(0).click();

             } else {
                System.out.println("Movies are not found");

                 return;
                }
            } catch (Exception e) {
                System.out.println("Error");

        }


     //Genere
      Assert.assertTrue(movieDetailsPage.footerElements(), "Genere Elements not displayed");

     //Language
      List<String> actualLanguages = movieDetailsPage.AudioLanguage();
      List<String> expectedLanguages = Arrays.asList("Spanish", "French", "English", "Italian", "Russian");

      Assert.assertEquals(actualLanguages, expectedLanguages, "Audio languages list does not match!");

      //Rating
      Assert.assertTrue(movieDetailsPage.RatingCounter(),"Rating Counter not exist");
      Assert.assertTrue(movieDetailsPage.RatingAverage(),"Rating Average not exist");

    //Budget
     Assert.assertTrue(movieDetailsPage.Budget(),"Budget not exist");
     Assert.assertTrue(movieDetailsPage.ReleaseDate(),"Release date not exist");

    }

    @Test(priority = 4)
    public void similarMovieContainer() {

        try {
            List<WebElement> movies = driver.findElements(By.cssSelector(".slick-slide img"));
            if (movies.size() > 0) {
                movies.get(0).click();

            } else {
                System.out.println("Movies are not found");

                return;
            }
          } catch (Exception e) {
            System.out.println("Error");

            String actualString = "More like this";
            String expectedString = movieDetailsPage.HeadingOfSimilarMovie();
            Assert.assertEquals(actualString, expectedString, "Heading not find");


            List<String> similarMovies=movieDetailsPage.ListOfSimilarMovies();
            System.out.println(similarMovies);
            Assert.assertTrue(similarMovies.size() > 0, "No such Movies are exist");


          }


        }

       @AfterMethod
       public void TearDown () {
       driver.close();
      }

  }


