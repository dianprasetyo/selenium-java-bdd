package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    @FindBy(id = "option-label-size-143-item-170")
    WebElement label_size_xl;

    @FindBy(id = "option-label-size-143-item-169")
    WebElement label_size_l;

    @FindBy(id = "option-label-size-143-item-168")
    WebElement label_size_m;

    @FindBy(id = "option-label-size-143-item-167")
    WebElement label_size_s;

    @FindBy(id = "option-label-size-143-item-166")
    WebElement label_size_xs;

    @FindBy(id = "option-label-color-93-item-58")
    WebElement label_color_red;

    @FindBy(id = "option-label-color-93-item-56")
    WebElement label_color_orange;

    @FindBy(id = "option-label-color-93-item-50")
    WebElement label_color_blue;

    @FindBy(id = "option-label-color-93-item-53")
    WebElement label_color_green;

    @FindBy(id = "option-label-color-93-item-49")
    WebElement label_color_black;

    @FindBy(id = "option-label-size-143-item-175")
    WebElement label_pants_size_32;

    @FindBy(id = "option-label-size-143-item-176")
    WebElement label_pants_size_33;

    @FindBy(id = "option-label-size-143-item-177")
    WebElement label_pants_size_34;

    @FindBy(id = "option-label-size-143-item-178")
    WebElement label_pants_size_36;


    @FindBy(id = "qty")
    WebElement input_box_qty;

    @FindBy(id = "product-addtocart-button")
    WebElement button_add_to_cart;

    @FindBy(xpath = "//a[contains(@href, 'https://magento.softwaretestingboard.com/checkout/cart/')]")
    WebElement cartIcon;

    @FindBy(id = "top-cart-btn-checkout")
    WebElement button_proceed_to_checkout;

    WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setLabel_top_size_xl() {
        label_size_xl.click();
    }

    public void setLabel_top_size_l() {
        label_size_l.click();
    }

    public void setLabel_top_size_m() {
        label_size_m.click();
    }

    public void setLabel_top_size_s() {
        label_size_s.click();
    }


    public void setLabel_top_size_xs() {
        label_size_xs.click();
    }

    public void setLabel_color_red() {
        label_color_red.click();
    }

    public void setLabel_color_blue() {
        label_color_blue.click();
    }

    public void setLabel_color_orange() {
        label_color_orange.click();
    }

    public void setLabel_color_black() {
        label_color_black.click();
    }

    public void setLabel_color_green() {
        label_color_green.click();
    }

    public void setLabel_bottom_size_32() {
        label_pants_size_32.click();
    }

    public void setLabel_bottom_size_33() {
        label_pants_size_33.click();
    }

    public void setLabel_bottom_size_34() {
        label_pants_size_34.click();
    }

    public void setLabel_bottom_size_36() {
        label_pants_size_36.click();
    }

    public void setInput_box_qty(String qty) {
        input_box_qty.clear();
        input_box_qty.sendKeys(qty);
    }

    public void clickButton_add_to_cart() {
        button_add_to_cart.click();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickButton_proceed_to_checkout() {
        button_proceed_to_checkout.click();
    }
}
