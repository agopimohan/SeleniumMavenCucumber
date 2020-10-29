package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.HomePage;

public class HomePageSteps {

    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context)
    {
        testContext = context;
        homePage = testContext.getPageObjectManager ().getHomePage ();
    }


    @Given("User is on Home page")
    public void user_is_on_home_page() {

        homePage.navigate_to_homepage ( FileReaderManager.getInstance ().getConfigReader ().getApplicationUrl ());

    }

    @When("User click on search icon")
    public void user_click_on_search_icon() {

        homePage.clickSearch ();

    }

    @When("enters {string} on search form")
    public void enters_on_search_form(String item) {

        homePage.perform_search ( item );

    }
}
