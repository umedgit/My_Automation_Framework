package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pom_AccountPage extends Pom_Abstract {

    public Pom_AccountPage() {
        PageFactory.initElements(driver, this);
    }

    //====================My Account Elements====================//
    @FindBy(css = "a[title='Addresses']")
    private WebElement btnMyAddresses;
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

    WebElement webElement;

    @Override
    void setWebElement(String elementName) {
        switch (elementName) {
            case "My addresses button":       webElement = btnMyAddresses;      break;
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
        }
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
    public void selectRandomDropDown(String elementName) {
        setWebElement(elementName);
        selectRandomDropDown(webElement);
    }

    @Override
    public List<WebElement> getListOfWebelement(String elementName) {

        List<WebElement> listOfWebElement = null;

        switch (elementName){
            case "Address Subheading": listOfWebElement = h3AddressSubheading; break;
        }
        return listOfWebElement;
    }
}
