package stepDefinitions;

import helper.RetryHelper;
import io.cucumber.java.en.*;
import managers.PageObjectManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;
import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver driver;
    HomePage homePage;
    ProductListingPage productListingPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    PageObjectManager pageObjectManager;

    @Given("User is on Home page")
    public void user_is_on_home_page() {

        System.setProperty ("webdriver.chrome.driver", "C:\\Users\\aishg\\Desktop\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        driver.manage ().timeouts ().implicitlyWait ( 10, TimeUnit.SECONDS );
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage ();
        homePage.navigate_to_homepage ();
        driver.manage ().window ().maximize ();
        
    }

    @When("User click on search icon")
    public void user_click_on_search_icon() {

        homePage.clickSearch ();
        
    }

    @When("enters {string} on search form")
    public void enters_on_search_form(String item) {

        homePage.perform_search ( item );
        
    }
    @When("choose to buy the first item on the search results page")
    public void choose_to_buy_the_first_item_on_the_search_results_page() {

        productListingPage = pageObjectManager.getProductListingPage ();
        productListingPage.select_Product ( 0 );
        productListingPage.select_Colour ( "white" );
        productListingPage.select_Size ( "medium" );
        productListingPage.click_AddToCart ();
        
    }
    @When("moves to checkout from mini cart")
    public void moves_to_checkout_from_mini_cart() {

        cartPage = pageObjectManager.getCartPage ();
        cartPage.clickOn_Cart ();
        cartPage.clickOn_ContinueToCheckout ();
    }

    @When("enters the personal information on checkout page")
    public void enters_the_personal_information_on_checkout_page() {

        checkOutPage = pageObjectManager.getCheckoutPage ();
        checkOutPage.fill_PersonalDetails ();

        
    }
    @When("accepts the terms and conditions")
    public void accepts_the_terms_and_conditions() {

        checkOutPage.select_Terms ( true );
        
    }
    @When("place the order")
    public void place_the_order() {

        checkOutPage.click_PlaceOrder ();
        driver.quit ();
        
    }
}
