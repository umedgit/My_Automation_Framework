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


    private WebElement webElement;

    @Override
    void setWebElement(String elementName) {
        switch (elementName) {
            case "My addresses button":       webElement = btnMyAddresses;      break;
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
        return null;
    }

    @Override
    public void clickBtnUnder(String parentElement, String childElement) {
    }

    @Override
    public String getPageLink() {
        return "http://automationpractice.com/index.php?controller=my-account";
    }
}
