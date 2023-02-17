package pageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    @FindBy(id = "checkout-step-shipping")
    WebElement field_shipping_address;

    @FindBy(name = "ko_unique_1")
    WebElement radio_button_best_way;

    @FindBy(xpath = "//span[(text() = 'Next')]")
    WebElement button_next;

    @FindBy(css = ".action.primary.checkout")
    WebElement button_place_order;

    @FindBy(id = "opc-sidebar")
    WebElement order_summary_section;

    @FindBy(xpath = "//div[@id='opc-sidebar']/div/div/div[2]/div/ol/li/div/div/div/div/strong")
    WebElement first_product_order_summary_name;

    @FindBy(xpath = "//div[@id='opc-sidebar']/div/div/div[2]/div/ol/li/div/div/div/div[2]/span/span/span")
    WebElement first_product_summary_price;

    @FindBy(xpath = "//div[@id='opc-sidebar']/div/div/div[2]/div/ol/li[2]/div/div/div/div/strong")
    WebElement second_product_order_summary_name;

    @FindBy(xpath = "//div[@id='opc-sidebar']/div/div/div[2]/div/ol/li[2]/div/div/div/div[2]/span/span/span")
    WebElement second_product_summary_price;

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyAddress() {
        field_shipping_address.isDisplayed();
    }

    public void clickShippingBestWay() {
        radio_button_best_way.click();
    }

    public void clickButtonNext() {
        button_next.click();
    }

    public void verifyOrderSummary() {
        order_summary_section.isDisplayed();
    }

    public void clickButtonPlaceOrder() {
        button_place_order.isEnabled();
        button_place_order.click();
    }

    public void verifyFirstProductName(String firstProductName) {
        first_product_order_summary_name.isEnabled();
        first_product_order_summary_name.isDisplayed();

        String firstProductTitle = first_product_order_summary_name.getText();
        Assert.assertEquals(firstProductName, firstProductTitle);
    }

    public void verifyFirstProductPrice(String price) {
        first_product_summary_price.isEnabled();
        first_product_summary_price.isDisplayed();

        String ActualFirstProductPrice = first_product_summary_price.getText();
        Assert.assertEquals(price, ActualFirstProductPrice);
    }

    public void verifySecondProductName(String secondProductName) {
        second_product_order_summary_name.isEnabled();
        second_product_order_summary_name.isDisplayed();

        String secondProductTitle = second_product_order_summary_name.getText();
        Assert.assertEquals(secondProductName, secondProductTitle);
    }

    public void verifySecondProductPrice(String price) {
        second_product_summary_price.isEnabled();
        second_product_summary_price.isDisplayed();

        String ActualSecondProductPrice = second_product_summary_price.getText();
        Assert.assertEquals(price, ActualSecondProductPrice);
    }
}
