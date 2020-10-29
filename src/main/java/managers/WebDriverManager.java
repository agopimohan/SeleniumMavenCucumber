package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private WebDriver driver;
    private static EnvironmentType envType;
    private static DriverType driverType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";


    public WebDriverManager()
    {
        driverType = FileReaderManager.getInstance ().getConfigReader ().getBrowser ();
        envType = FileReaderManager.getInstance ().getConfigReader ().getEnvironment ();
    }

    public WebDriver getDriver()
    {
        if(driver == null) createDriver();
        return driver;
    }

    private WebDriver createDriver()
    {
        switch(envType){
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }

        return driver;

    }

    private WebDriver createLocalDriver ()
    {
        switch(driverType)
        {
            case CHROME:
                System.setProperty ( CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance ().getConfigReader ().getDriverPath () );
                driver = new ChromeDriver ();
                break;
            case FIREFOX:
                driver = new FirefoxDriver (  );
                break;
            case INTERNETEXPLORER:
                driver = new InternetExplorerDriver ( );
                break;
        }

        if(FileReaderManager.getInstance ().getConfigReader ().getBrowserWindowSize ())
            driver.manage ().window ().maximize ();

        driver.manage ().timeouts ().implicitlyWait ( FileReaderManager.getInstance ().getConfigReader ().getImplicitlyWait (), TimeUnit.SECONDS );
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }


}
