package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElements {

    public HomePageElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Log in")
    public WebElement loginBtn;

   @FindAll(@FindBy(css = "div[class='product-item']"))
    public List<WebElement> productList;

    @FindBy(id = "add-to-cart-button-31")
    public WebElement addCart;

    @FindBy(css = "p[class='content'] ")
    public WebElement successMessage;
    @FindBy(xpath = "(//a[@class='ico-cart'])[1]")
    public WebElement shoppingCart;
}
