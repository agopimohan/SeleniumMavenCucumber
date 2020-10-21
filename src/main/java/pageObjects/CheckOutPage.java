package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

    public CheckOutPage(WebDriver driver)
    {
        PageFactory.initElements ( driver, this );
    }

    @FindBy(how = How.ID, using = "billing_first_name")
    private WebElement txtbx_FirstName;

    @FindBy(how = How.ID, using = "billing_last_name")
    private WebElement txtbx_LastName;

    @FindBy(how = How.ID, using = "billing_address_1")
    private WebElement txtbx_AddressLine1;

    @FindBy(how = How.ID, using = "billing_postcode")
    private WebElement txtbx_PostCode;

    @FindBy(how = How.ID, using = "billing_phone")
    private WebElement txtbx_Phone;

    @FindBy(how = How.ID, using = "billing_email")
    private WebElement txtbx_Email;

    @FindBy(how = How.ID, using = "billing_city")
    private WebElement txtbx_City;

    @FindBy(how = How.ID, using = "billing_state")
    private WebElement drpdown_State;

    @FindBy(how = How.ID, using = "terms")
    private WebElement chkbox_Terms;

    @FindBy(how = How.ID, using = "place_order")
    private WebElement btn_PlaceOrder;

    public void enter_FirstName(String firstname) {
        txtbx_FirstName.sendKeys ( firstname );
    }

    public void enter_LastName(String lastname) {
        txtbx_LastName.sendKeys ( lastname );
    }

    public void enter_Address(String address) {
        txtbx_AddressLine1.sendKeys ( address );
    }

    public void enter_PostCode(String postcode) {
        txtbx_PostCode.sendKeys ( postcode );
    }

    public void enter_Phone(String phone) {
        txtbx_Phone.sendKeys ( phone );
    }

    public void enter_Email(String email) {
        txtbx_Email.sendKeys ( email );
    }

    public void enter_City(String city) {
        txtbx_City.sendKeys ( city );
    }

    public void select_State(String state) {
        Select selection =new Select ( drpdown_State );
        selection.selectByVisibleText ( state );
    }

    public void select_Terms(boolean value) {
        if (value) {

            try { chkbox_Terms.click ();;}
            catch (StaleElementReferenceException e) {chkbox_Terms.click ();}
        }
    }

    public void click_PlaceOrder() {
        btn_PlaceOrder.submit ();

    }

    public void fill_PersonalDetails() {
        enter_FirstName("Automation");
        enter_LastName("Test");
        enter_Phone("0000000000");
        enter_Email("Automation@gmail.com");
        enter_City("Delhi");
        enter_Address("Shalimar Bagh");
        enter_PostCode("110088");
        select_State("Delhi");

    }
}
