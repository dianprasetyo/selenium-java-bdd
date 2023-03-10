package pageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderPage {

    @FindBy(xpath = "//table[@id='my-orders-table']/tbody/tr/td")
    WebElement my_order_invoice_number;

    @FindBy(xpath = "//table[@id='my-orders-table']/tbody/tr/td[6]/a/span")
    WebElement view_my_order_detail;

    @FindBy(xpath = "//strong[(text() = 'Montana Wind Jacket' or . = 'Montana Wind Jacket')]")
    WebElement my_order_first_product_name;

    @FindBy(xpath = "//span[(text() = '$98.00' or . = '$98.00')]")
    WebElement my_order_first_product_price;

    @FindBy(xpath = "//strong[(text() = 'Cronus Yoga Pant ' or . = 'Cronus Yoga Pant ')]")
    WebElement my_order_second_product_name;

    @FindBy(xpath = "//span[(text() = '$48.00' or . = '$48.00')]")
    WebElement my_order_second_product_price;

    WebDriver driver;

    public MyOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void invoiceNumber() {
        my_order_invoice_number.isDisplayed();
    }

    public void clickViewMyOrderDetail() {
        view_my_order_detail.click();
    }

    public void verifyMyOrderFirstProductName(String name) {
        my_order_first_product_name.isEnabled();
        my_order_first_product_name.isDisplayed();

        String actualFirstProductName = my_order_first_product_name.getText();
        Assert.assertEquals(name, actualFirstProductName);
    }

    public void verifyMyOrderFirstProductPrice(String price) {
        my_order_first_product_price.isEnabled();
        my_order_first_product_price.isDisplayed();

        String actualFirstProductPrice = my_order_first_product_price.getText();
        Assert.assertEquals(price, actualFirstProductPrice);
    }

    public void verifyMyOrderSecondProductName(String name) {
        my_order_second_product_name.isEnabled();
        my_order_second_product_name.isDisplayed();

        String actualSecondProductName = my_order_second_product_name.getText();
        Assert.assertEquals(name, actualSecondProductName);
    }

    public void verifyMyOrderSecondProductPrice(String price) {
        my_order_second_product_price.isEnabled();
        my_order_second_product_price.isDisplayed();

        String actualSecondProductPrice = my_order_second_product_price.getText();
        Assert.assertEquals(price, actualSecondProductPrice);
    }
}
