package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {

    private WebDriver driver;
    private ProductListingPage productListingPage;
    private CartPage cartPage;
    private HomePage homePage;
    private CheckOutPage checkoutPage;
    private ConfirmationPage confirmationPage;

    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }

    public HomePage getHomePage(){

        return (homePage == null) ? homePage = new HomePage(driver) : homePage;

    }

    public ProductListingPage getProductListingPage() {

        return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;

    }

    public CartPage getCartPage() {

        return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;

    }

    public CheckOutPage getCheckoutPage() {

        return (checkoutPage == null) ? checkoutPage = new CheckOutPage(driver) : checkoutPage;

    }
}
