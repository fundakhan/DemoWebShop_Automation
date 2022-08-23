package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPageElements {

    public AccountPageElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "toffee@gmail.com")
    public WebElement accountEmail;

    @FindAll(@FindBy(css = "div[class='validation-summary-errors']"))
    public List<WebElement> unsuccessfulMessage;

    @FindBy(id = "termsofservice")
    public WebElement agreeRadioBtn;


    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement countries;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    public WebElement states;
    @FindBy(id = "BillingNewAddress_City")
    public WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement zipcode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phoneNumber;

    @FindBy(id = "billing-buttons-container")
    public WebElement continueBtn;

    @FindAll(@FindBy(id = "billing-address-select"))
    public List<WebElement> selectAddress;
    @FindBy(css = "input[onclick='Billing.save()']")
    public WebElement continueBillingBtn;

    @FindBy(linkText = "Addresses")
    public WebElement addressButton;

    @FindAll(@FindBy(css = "ul[class='info']"))
    public List<WebElement> addressTable;

    @FindBy(css = "input[onclick='Shipping.save()']")
    public WebElement continueShippingBtn;

    @FindBy(id = "shippingoption_1")
    public WebElement nextDayRadioBtn;

    @FindBy(css = "input[onclick='ShippingMethod.save()']")
    public WebElement shippingMethodBtn;

    @FindBy(xpath = "(//*[@class='method-name'])[5]")
    public WebElement cashBtn;

    @FindBy(css = "input[onclick='PaymentMethod.save()']")
    public WebElement continuePaymentBtn;

    @FindBy(css = "input[onclick='PaymentInfo.save()']")
    public WebElement paymentInfoContinueBtn;

    @FindBy(css = "input[onclick='ConfirmOrder.save()']")
    public WebElement confirmBtn;

    @FindBy(css = "div[class='title']")
    public WebElement successMessage;
}
