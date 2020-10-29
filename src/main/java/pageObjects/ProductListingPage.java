package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import selenium.Wait;

import java.util.List;

public class ProductListingPage {

    WebDriver  driver;

    public ProductListingPage(WebDriver driver)
    {

        this.driver = driver;
        PageFactory.initElements ( driver, this );
    }

    @FindBy(how = How.XPATH, using = "//div[@class='noo-product-inner']")
    private List<WebElement> prod_list;

    @FindBy(how = How.ID, using = "pa_color")
    private WebElement drpdown_colour;

    @FindBy(how = How.ID, using = "pa_size")
    private WebElement drpdown_size;

    @FindBy(how = How.XPATH, using = "//*[@class='single_add_to_cart_button button alt']")
    private  WebElement btn_addtocart;

    public void select_Colour(String colour)
    {
        Select color_selection = new Select ( drpdown_colour );
        color_selection.selectByValue ( colour );
        Wait.untilPageLoadComplete ( driver );

    }

    public void select_Size(String size)
    {
        Select size_selection = new Select ( drpdown_size );
        size_selection.selectByValue ( size );
        Wait.untilPageLoadComplete ( driver );
    }

    public void click_AddToCart()
    {

        btn_addtocart.click ();
    }

    public void select_Product(int index)
    {
        prod_list.get ( index ).click ();
        Wait.untilPageLoadComplete ( driver );
    }

    public String getProductName(int productNumber)
    {
        return prod_list.get ( productNumber ).findElement ( By.cssSelector ("h3") ).getText ();
    }
}
