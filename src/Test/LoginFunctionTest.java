package Test;

import POM.AccountPageElements;
import POM.HomePageElements;
import POM.LoginPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginFunctionTest extends BaseDriver {

    LoginPageElements loginPageElements;

    HomePageElements homePageElements;

    AccountPageElements accountPageElements;


    @Parameters({"username", "password"})
    @Test
    public void loginPositiveTest(String username, String password) {

        loginPageElements = new LoginPageElements(driver);
        homePageElements = new HomePageElements(driver);
        accountPageElements = new AccountPageElements(driver);

        wait.until(ExpectedConditions.visibilityOf(homePageElements.loginBtn)).click();
        loginPageElements.emailInput.sendKeys(username);
        loginPageElements.password.sendKeys(password);
        loginPageElements.loginButton.click();

        String expected = "toffee@gmail.com";

       Assert.assertTrue(accountPageElements.accountEmail.isDisplayed());

        Assert.assertEquals(accountPageElements.accountEmail.getText(),expected);

    }

    @Parameters({"username", "password"})
    @Test
    public void loginNegativeTest(String username, String password) {

        loginPageElements = new LoginPageElements(driver);
        homePageElements = new HomePageElements(driver);
        accountPageElements = new AccountPageElements(driver);

        homePageElements.loginBtn.click();
        loginPageElements.emailInput.sendKeys(username);
        loginPageElements.password.sendKeys(password);
        loginPageElements.loginButton.click();

        String expectedUnsuccessfulResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        for (WebElement wb : accountPageElements.unsuccessfulMessage){
            Assert.assertTrue(wb.isDisplayed());
            Assert.assertEquals(wb.getText(),expectedUnsuccessfulResult);
        }
    }
}
