package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    TestContext context;

    public Hooks(TestContext testContext)
    {
        this.context = testContext;
    }

    @Before
    public void BeforeSteps()
    {

    }

    @After
    public void AfterSteps()
    {
        context.getWebDriverManager ().closeDriver ();
    }
}
