package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pom_AccountPage extends Abstract_PomPage {

    public Pom_AccountPage() {
        PageFactory.initElements(driver, this);
    }


    //====================My Account Elements====================//
    @FindBy(css = "a[title='Addresses']")
    private WebElement btnMyAddresses;


    @Override
    WebElement getWebElement(String elementName) {

        WebElement webElement = null;

        switch (elementName) {
            case "My addresses button":       webElement = btnMyAddresses;      break;
        }
        return webElement;
    }

    @Override
    public void clickFunction(String elementName) {
        waitScrollClickFunction(getWebElement(elementName));
    }

    @Override
    public void sendKeysFunction(String elementName, String text) {
        waitClearSendKeysFunction(getWebElement(elementName), text);
    }

    @Override
    public String getElementText(String elementName) {
        return getWebElement(elementName).getText();
    }

    @Override
    public void selectRandomFromDropDown(String elementName) {
        selectRandomDropDown(getWebElement(elementName));
    }

    @Override
    public List<WebElement> getListOfWebelement(String elementName) {
        return null;
    }


    @Override
    public String getPageLink() {
        return "http://automationpractice.com/index.php?controller=my-account";
    }

}
