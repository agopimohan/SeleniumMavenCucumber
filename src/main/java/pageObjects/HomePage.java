package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(how = How.XPATH, using = "//a[@class='noo-search']")
    private WebElement iconSearch;

    @FindBy(how = How.XPATH, using = "//*[@name='s']")
    private  WebElement txtbox_search;


    public void clickSearch()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].click();",iconSearch );
    }

    public void navigate_to_homepage()
    {
        driver.get("http://shop.demoqa.com/");
    }

    public void perform_search(String search)
    {
        txtbox_search.sendKeys ( search );
        txtbox_search.sendKeys ( Keys.RETURN );
    }
}
