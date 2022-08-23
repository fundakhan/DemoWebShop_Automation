package Test;

import POM.AccountPageElements;
import POM.HomePageElements;
import POM.LoginPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PlaceAnOrderTest extends BaseDriver {

    LoginPageElements loginPageElements;

    HomePageElements homePageElements;

    AccountPageElements accountPageElements;


    @Parameters({"username", "password"})
    @Test
    public void PlaceAnOrder(String username, String password) {

    loginPageElements =new

    LoginPageElements(driver);

    homePageElements =new

    HomePageElements(driver);

    accountPageElements =new

    AccountPageElements(driver);

        wait.until(ExpectedConditions.visibilityOf(homePageElements.loginBtn)).click();
        loginPageElements.emailInput.sendKeys(username);
        loginPageElements.password.sendKeys(password);
        loginPageElements.loginButton.click();

        for (int i = 0; i < homePageElements.productList.size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(homePageElements.productList.get(1))).click();

        }
        homePageElements.addCart.click();

        String expectedResult = "The product has been added to your shopping cart";
        Assert.assertTrue(homePageElements.successMessage.isDisplayed());
        Assert.assertEquals(homePageElements.successMessage.getText(),expectedResult);







}
}
