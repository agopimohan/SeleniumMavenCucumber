package seleniumtests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    public static void main(String[] args)
    {
        System.setProperty ("webdriver.chrome.driver", "C:\\Users\\aishg\\Desktop\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        driver.manage ().timeouts ().implicitlyWait ( 10, TimeUnit.SECONDS );

        driver.get ( "http://shop.demoqa.com/" );
        driver.manage ().window ().maximize ();
        WebDriverWait wait = new WebDriverWait (driver, 5 );

        WebElement search = driver.findElement ( By.xpath ( "//a[@class='noo-search']") );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].click();",search );

        WebElement searchForm = driver.findElement ( By.xpath ( "//*[@name='s']" ) );
        searchForm.sendKeys ( "DRESS" );
        searchForm.sendKeys ( Keys.RETURN );

        List<WebElement> items = driver.findElements ( By.xpath ( "//div[@class='noo-product-inner']" ) );
        items.get(0).click ();
        Select colourSelection = new Select ( driver.findElement ( By.id ( "pa_color" ) ) );
        Select sizeSelection = new Select(driver.findElement ( By.id ( "pa_size" ) ));
        colourSelection.selectByValue ( "white" );
        sizeSelection.selectByValue ( "medium" );
        WebElement addToCart = driver.findElement ( By.xpath ( "//*[@class='single_add_to_cart_button button alt']" ) );
        addToCart.click ();

        String cart = "//*[@class='cart-name-and-total']";
        retryStaleElementClick(cart);

        WebElement checkout = driver.findElement(By.cssSelector(".checkout-button.alt"));
        checkout.click ();

        driver.findElement ( By.id("billing_first_name") ).sendKeys ( "abc" );
        driver.findElement ( By.id("billing_last_name") ).sendKeys ( "xyz" );
        driver.findElement ( By.id("billing_address_1") ).sendKeys ( "india" );
        driver.findElement ( By.id("billing_postcode") ).sendKeys ( "1234" );
        driver.findElement ( By.id("billing_phone") ).sendKeys ( "1234567890" );
        driver.findElement ( By.id("billing_email") ).sendKeys ( "test@test.com" );
        driver.findElement ( By.id("billing_city") ).sendKeys ( "test" );

        Select state = new Select(driver.findElement ( By.id("billing_state") ));
        state.selectByVisibleText ( "Arunachal Pradesh" );

        String terms = "//*[@id='terms']";
        retryStaleElementClick ( terms );

        WebElement placeorder = driver.findElement ( By.id("place_order") );
        placeorder.click ();

        String actual_title = driver.getTitle ();

        System.out.println ( actual_title );
        driver.quit ();


    }

    static void retryStaleElementClick(String value)
    {
        try{
            WebElement element = driver.findElement (By.xpath (value));
            element.click ();
        }
        catch(StaleElementReferenceException e)
        {
            WebElement element = driver.findElement (By.xpath (value));
            element.click ();
        }
    }
}
