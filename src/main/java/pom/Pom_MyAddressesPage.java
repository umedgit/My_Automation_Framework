package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//This class holds hardcoded locators of the My Addresses page and implementing
//functions of the parent Pom_Abstract class
public class Pom_MyAddressesPage extends Abstract_PomPage {

    public Pom_MyAddressesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[title='Add an address']")
    private WebElement btnAddAddress;
    @FindBy(css = "h1[class='page-subheading']")
    private WebElement lblFormName;
    //====================Your Addresses Form Elements====================//
    @FindBy(id = "firstname")
    private WebElement txtFirstName;
    @FindBy(id = "lastname")
    private WebElement txtLastName;
    @FindBy(id = "address1")
    private WebElement txtAddress1;
    @FindBy(id = "id_state")
    private WebElement selState;
    @FindBy(id = "postcode")
    private WebElement txtPostcode;
    @FindBy(id = "phone")
    private WebElement txtPhone;
    @FindBy(id = "city")
    private WebElement txtCity;
    @FindBy(id = "alias")
    private WebElement txtAlias;
    @FindBy(id = "submitAddress")
    private WebElement btnSave;
    @FindBy(className = "page-subheading")
    private List<WebElement> h3AddressSubheading;
    @FindBy(css = "div[class='col-xs-12 col-sm-6 address']")
    private List<WebElement> blkAddress;

    private WebElement webElement;

    @Override
    void setWebElement(String elementName) {
        switch (elementName) {
            case "Add a new address button":  webElement = btnAddAddress;       break;
            case "Form title":                webElement = lblFormName;         break;
            //Form elements===============================================//
            case "First Name":                webElement = txtFirstName;        break;
            case "Last Name":                 webElement = txtLastName;         break;
            case "Address":                   webElement = txtAddress1;         break;
            case "State":                     webElement = selState;            break;
            case "Zip/Postal Code":           webElement = txtPostcode;         break;
            case "Home phone":                webElement = txtPhone;            break;
            case "City":                      webElement = txtCity;             break;
            case "Address title":             webElement = txtAlias;            break;
            case "Save Button":               webElement = btnSave;             break;
            //case "Address block":             webElement = blkAddress;          break;
        }
    }

    public void clickBtnUnderAddressBlock(String parentElement, String childElement) {

//        WebElement element = driver.findElement(By.xpath("//h3[text()='New Address']//ancestor::ul//a[@title='Update']"));

        WebElement element = driver.findElement(By.xpath("//h3[text()='" + parentElement +
               "']//ancestor::ul//a[@title='" + childElement + "']"));

        waitScrollClickFunction(element);
    }

    @Override
    public String getPageLink() {
        return "http://automationpractice.com/index.php?controller=addresses";
    }

    @Override
    public void clickFunction(String elementName) {
        setWebElement(elementName);
        waitScrollClickFunction(webElement);
    }

    @Override
    public void sendKeysFunction(String elementName, String text) {
        setWebElement(elementName);
        waitClearSendKeysFunction(webElement, text);
    }

    @Override
    public String getElementText(String elementName) {
        setWebElement(elementName);
        return webElement.getText();
    }

    @Override
    public void selectRandomFromDropDown(String elementName) {
        setWebElement(elementName);
        selectRandomDropDown(webElement);
    }

    @Override
    public List<WebElement> getListOfWebelement(String elementName) {

        List<WebElement> listOfWebElement = null;

        switch (elementName){
            case "Address Subheading": listOfWebElement = h3AddressSubheading; break;
            case "Address block":      listOfWebElement = blkAddress;          break;
        }
        return listOfWebElement;
    }

}
