package Test;

import POM.AccountPageElements;
import POM.HomePageElements;
import POM.LoginPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckoutFunctionTest extends BaseDriver {

    LoginPageElements loginPageElements;

    HomePageElements homePageElements;

    AccountPageElements accountPageElements;


    @Parameters({"username", "password"})
    @Test
    public void PlaceAnOrder(String username, String password) {

        loginPageElements = new LoginPageElements(driver);

        homePageElements = new HomePageElements(driver);

        accountPageElements = new AccountPageElements(driver);

        wait.until(ExpectedConditions.visibilityOf(homePageElements.loginBtn)).click();
        loginPageElements.emailInput.sendKeys(username);
        loginPageElements.password.sendKeys(password);
        loginPageElements.loginButton.click();

        homePageElements.shoppingCart.click();

        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.agreeRadioBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.checkoutBtn)).click();


        wait.until(ExpectedConditions.urlContains("onepagecheckout"));

        for (WebElement wb : accountPageElements.selectAddress){
            Select selectAddress = new Select(wb);
            selectAddress.selectByIndex(0);
        }

        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.continueBillingBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.continueShippingBtn)).click();

        accountPageElements.nextDayRadioBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.shippingMethodBtn)).click();

        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.cashBtn)).click();
        accountPageElements.continuePaymentBtn.click();

        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.paymentInfoContinueBtn)).click();

        wait.until(ExpectedConditions.elementToBeClickable(accountPageElements.confirmBtn)).click();

        wait.until(ExpectedConditions.urlContains("checkout/completed/"));

        String expected = "Your order has been successfully processed!";

        Assert.assertTrue(accountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(accountPageElements.successMessage.getText(),expected);






    }


    }
