package pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    WebElement txt_sign_in;

    @FindBy(id = "email")
    WebElement txt_email;

    @FindBy(id = "pass")
    WebElement txt_password;

    @FindBy(id = "send2")
    WebElement button_sign_in;

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTopSignIn() {
        txt_sign_in.click();
    }

    public void enterEmail(String email) {
        txt_email.sendKeys(email);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickLoginButton(){
        button_sign_in.click();
    }
}
