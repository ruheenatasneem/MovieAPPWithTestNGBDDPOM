import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import java.util.List;
import pages.PopularPage;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class PopularPageTest {

    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    PopularPage popularPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage =new LoginPage(driver);
        homePage =new HomePage(driver);
        popularPage=new PopularPage(driver);

        loginPage.LogInToApplication("rahul", "rahul@2021");
        String expedtedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expedtedUrl));

    }

    @Test (priority = 1)

    public void PopularPageUI() {

    popularPage.clickPopular();
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));

    List<WebElement> moviesElements=driver.findElements(By.xpath("//li[@class='movie-icon-item']/a[@class='link-item']"));

    if ( moviesElements.size() >0){
        System.out.println("Found"+ moviesElements.size()+"movie.links");

        for ( WebElement moviesElement : moviesElements)
        {
            String href= moviesElement.getAttribute("href");
            System.out.println(href);
        }
      }
    else
        System.out.println("No movie links are found");

    }

    @Test(priority = 2)
    public void movieSearch() {
      try {


         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

         popularPage.clickPopular();
         wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));

         popularPage.clickSearch();
         WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

         searchBox.sendKeys("Titanic");

         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='searchButton']"))).click();

         WebElement Movie = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Titanic']")));
         Assert.assertTrue(Movie.isDisplayed());

         WebElement titanic = driver.findElement(By.xpath("//img[@alt='Titanic']/parent::a"));
         titanic.click();

         }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
