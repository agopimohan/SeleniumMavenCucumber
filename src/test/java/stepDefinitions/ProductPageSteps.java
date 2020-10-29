package stepDefinitions;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;
import pageObjects.ProductListingPage;

public class ProductPageSteps {

    TestContext testContext;
    ProductListingPage productListingPage;

    public ProductPageSteps(TestContext context)
    {
        testContext = context;
        productListingPage = testContext.getPageObjectManager ().getProductListingPage ();
    }


    @When("choose to buy the first item on the search results page")
    public void choose_to_buy_the_first_item_on_the_search_results_page() {

        String productname = productListingPage.getProductName ( 0 );
        testContext.getScenarioContext ().setContext ( Context.PRODUCT_NAME, productname );

        productListingPage.select_Product ( 0 );
        productListingPage.select_Colour ( "white" );
        productListingPage.select_Size ( "medium" );
        productListingPage.click_AddToCart ();

    }


}
