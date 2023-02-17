package StepDefinitions;

import io.cucumber.java.en.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.*;

import java.time.Duration;

public class RegisteredUserShopSteps {

    WebDriver driver = null;
    HomePage login;
    ProductDetailPage productDetail;
    CheckoutPage checkoutPage;
    OrderSuccessPage orderSuccessPage;
    MyOrderPage myOrderPage;

    private static final Dotenv dotenv = Dotenv.configure().load();


    @Given("user open chrome browser")
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @When("user navigate to luma website")
    public void navigateToWebsite() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
    }

    @And("user click sign in on top of the page")
    public void clickTopSignIn() {
        login = new HomePage(driver);

        login.clickTopSignIn();
    }

    @And("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterCredential(String email, String password) {
        email = dotenv.get(email);
        password = dotenv.get(password);

        login.enterEmail(email);
        login.enterPassword(password);
    }

    @And("user click sign in button")
    public void clickSignInButton() {
        login.clickLoginButton();
    }

    @And("^user navigate to product detail \"([^\"]*)\"$")
    public void montanaProductDetail(String product) throws InterruptedException {
        product = dotenv.get(product);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(product);
        Thread.sleep(2000);
    }

    @And("^user choose top size \"([^\"]*)\"$")
    public void chooseTopSize(String topSize) {
        productDetail = new ProductDetailPage(driver);

        switch (topSize) {
            case "XL":
                productDetail.setLabel_top_size_xl();
                break;
            case "L":
                productDetail.setLabel_top_size_l();
                break;
            case "M":
                productDetail.setLabel_top_size_m();
                break;
            case "S":
                productDetail.setLabel_top_size_s();
                break;
            case "XS":
                productDetail.setLabel_top_size_xs();
                break;
            default:
                throw new IllegalArgumentException("You are inputting wrong size");
        }
    }

    @And("^user choose bottom size \"([^\"]*)\"$")
    public void chooseBottomSize(String bottomSize) {
        switch (bottomSize) {
            case "32":
                productDetail.setLabel_bottom_size_32();
                break;
            case "33":
                productDetail.setLabel_bottom_size_33();
                break;
            case "34":
                productDetail.setLabel_bottom_size_34();
                break;
            case "36":
                productDetail.setLabel_bottom_size_36();
                break;
        }
    }

    @And("^user choose color \"([^\"]*)\"$")
    public void chooseColor(String color) {

        switch (color) {
            case "RED":
                productDetail.setLabel_color_red();
                break;
            case "BLUE":
                productDetail.setLabel_color_blue();
                break;
            case "BLACK":
                productDetail.setLabel_color_black();
                break;
            case "ORANGE":
                productDetail.setLabel_color_orange();
                break;
            case "GREEN":
                productDetail.setLabel_color_green();
                break;
            default:
                throw new IllegalArgumentException("You are inputting wrong color");
        }
    }

    @And("^user set quantity to \"([^\"]*)\"$")
    public void setQuantity(String qty) {
        productDetail.setInput_box_qty(qty);
    }

    @And("user click add to cart button")
    public void clickAddToCartButton() throws InterruptedException {
        productDetail.clickButton_add_to_cart();
        Thread.sleep(5000);
    }

    @And("user click cart icon")
    public void clickCartIcon() {
        productDetail.clickCartIcon();
    }

    @And("user click proceed to checkout button")
    public void clickProceedToCheckoutButton() throws InterruptedException {
        productDetail.clickButton_proceed_to_checkout();
        Thread.sleep(5000);
    }

    @And("^user verify first product name is \"([^\"]*)\"$")
    public void verifyFirstProduct(String name) {
        checkoutPage = new CheckoutPage(driver);

        checkoutPage.verifyFirstProductName(name);
    }

    @And("^user verify first product price is \"([^\"]*)\"$")
    public void verifyFirstProductPrice(String price) {
        checkoutPage.verifyFirstProductPrice(price);
    }

    @And("^user verify second product name is \"([^\"]*)\"$")
    public void verifySecondProduct(String name) {

        checkoutPage.verifySecondProductName(name);
    }

    @And("^user verify second product price is \"([^\"]*)\"$")
    public void verifySecondProductPrice(String price) {
        checkoutPage.verifySecondProductPrice(price);
    }

    @And("user verify saved address is displayed")
    public void verifyAddress() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        checkoutPage.verifyAddress();
        driver.close();
    }

    @And("user click shipping method best way")
    public void clickBestWay() {
        checkoutPage.clickShippingBestWay();
    }

    @And("user click button next")
    public void clickButtonNext() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        Thread.sleep(5000);
        checkoutPage.clickButtonNext();
    }

    @And("user verify order summary")
    public void verifyOrderSummary() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        checkoutPage.verifyOrderSummary();
    }

    @And("user click place order")
    public void clickButtonPlaceOrder() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        Thread.sleep(5000);
        checkoutPage.clickButtonPlaceOrder();
    }

    @And("^user verify success message \"([^\"]*)\" is displayed$")
    public void verifySuccessMessage(String message) {
        orderSuccessPage = new OrderSuccessPage(driver);

        orderSuccessPage.verifySuccessPage(message);
    }

    @And("user go to my order page")
    public void myOrderPage() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://magento.softwaretestingboard.com/sales/order/history/");
        Thread.sleep(2000);
    }

    @And("user click view my order to see order detail")
    public void clickViewMyOrder() {
        myOrderPage = new MyOrderPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        myOrderPage.invoiceNumber();
        myOrderPage.clickViewMyOrderDetail();
    }

    @And("^user verify first product name on my order is \"([^\"]*)\"$")
    public void verifyMyOrderFirstProductName(String name) {
        myOrderPage.verifyMyOrderFirstProductName(name);
    }

    @And("^user verify first product price on my order is \"([^\"]*)\"$")
    public void verifyMyOrderFirstProductPrice(String price) {
        myOrderPage.verifyMyOrderFirstProductPrice(price);
    }

    @And("^user verify second product name on my order is \"([^\"]*)\"$")
    public void verifyMyOrderSecondProductName(String name) {
        myOrderPage.verifyMyOrderSecondProductName(name);
    }

    @And("^user verify second product price on my order is \"([^\"]*)\"$")
    public void verifyMyOrderSecondProductPrice(String price) {
        myOrderPage.verifyMyOrderSecondProductPrice(price);
    }

    @Then("user close browser")
    public void userCloseBrowser() {
        driver.close();
        driver.quit();
    }
}
