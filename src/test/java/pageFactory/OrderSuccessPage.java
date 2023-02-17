package pageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPage {

    @FindBy(xpath = "//span[(text() = 'Thank you for your purchase!')]")
    WebElement success_order_message;

    WebDriver driver;

    public OrderSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifySuccessPage(String message) {
        success_order_message.isDisplayed();

        String actualText = success_order_message.getText();
        Assert.assertEquals(message, actualText);
    }
}

