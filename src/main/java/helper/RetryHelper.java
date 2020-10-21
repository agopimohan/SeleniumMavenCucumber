package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetryHelper {

    public RetryHelper()
    {

    }

    public void retryStaleElementClick(WebDriver driver, String value)
    {
        try{
            WebElement element = driver.findElement ( By.xpath (value));
            element.click ();
        }
        catch(StaleElementReferenceException e)
        {
            WebElement element = driver.findElement (By.xpath (value));
            element.click ();
        }
    }

}
