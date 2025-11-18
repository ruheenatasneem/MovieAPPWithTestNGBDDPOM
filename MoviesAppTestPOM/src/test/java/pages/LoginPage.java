package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

By LogoLocator=By.className("login-website-logo");
By LogInHeadingLocator=By.className("sign-in-heading");
By LabelLocator=(By.className("input-label"));
By UserNameInputLocator=By.id("usernameInput");
By PassWordLocator=By.id("passwordInput");
By LogInButtonLocator=By.className("login-button");
By ErrorMsgLocator=By.className("error-message");

WebDriver driver;
WebDriverWait wait;

public LoginPage(WebDriver driver){
    this.driver=driver;
    this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));

}

public WebElement FindLogInImage(){
return  wait.until(ExpectedConditions.visibilityOfElementLocated(LogoLocator));

}

public String getLabelTextAt(int index){
    return driver.findElements(LabelLocator).get(index).getText();

}


public  String getLogInHeadingText(){
    return driver.findElement(LogInHeadingLocator).getText();

}

public void getUserNameInputText(String userNm){
     driver.findElement(UserNameInputLocator).sendKeys(userNm);

}

public void getPassWordLocatorText(String PssWrd){
    driver.findElement(PassWordLocator).sendKeys(PssWrd);

}

public void clickButton(){
    driver.findElement(LogInButtonLocator).click();
}

public String geErrorMsgLocator(){
    return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMsgLocator)).getText();
}

public void LogInToApplication(String userNm,String PssWrd){
    getUserNameInputText(userNm);
    getPassWordLocatorText(PssWrd);
    clickButton();
}



}

