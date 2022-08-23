package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

    public LoginPageElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[id='Email']")
    public WebElement emailInput;

    @FindBy(css = "input[id='Password']")
    public WebElement password;

    @FindBy(css = "input[class='button-1 login-button']")
    public WebElement loginButton;


}
