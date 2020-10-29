package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.CheckOutPage;
import testDataTypes.Customer;

public class CheckOutPageSteps {

    TestContext testContext;
    CheckOutPage checkOutPage;

    public CheckOutPageSteps(TestContext context) {
        testContext = context;
        checkOutPage = testContext.getPageObjectManager ( ).getCheckoutPage ( );
    }


    @When("accepts the terms and conditions")
    public void accepts_the_terms_and_conditions() {

        checkOutPage.select_Terms ( true );

    }

    @When("place the order")
    public void place_the_order() {

        checkOutPage.click_PlaceOrder ( );

    }

    @And("enters {string} personal information on checkout page")
    public void entersPersonalInformationOnCheckoutPage(String customername) {

        Customer customer = FileReaderManager.getInstance ().getJsonFileReader ().getCustomerByName ( customername );
        checkOutPage.fill_PersonalDetails (customer);
    }
}
