package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pom_Amazon_MainPage extends Abstract_PomPage {

    public Pom_Amazon_MainPage() {
        PageFactory.initElements(driver, this);
    }

    //=====================Login Page Elements==================//
    @FindBy(id = "twotabsearchtextbox")
    private WebElement txtSearch;
    @FindBy(id = "nav-search-submit-text")
    private WebElement btnSearch;
    @FindBy(css = "div[data-component-type='s-search-result']")
    private List<WebElement> blkSearchResultItem;
    @FindBy(id = "newBuyBoxPrice")
    private WebElement lblItemPrice;
    @FindBy(linkText = "Sign out")
    private WebElement lnkSignOut;

    //====================Abstract Methods code==================//

    @Override
    WebElement getWebElement(String elementName) {
        WebElement webElement = null;
        switch (elementName) {
            case "Search field":         webElement = txtSearch;        break;
            case "Sign Out link":        webElement = lnkSignOut;       break;
            case "Item price":           webElement = lblItemPrice;     break;
            case "Search button":        webElement = btnSearch;        break;
            //case "Search item":          webElement = blkSearchItem;    break;
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
    }

    @Override
    public List<WebElement> getListOfWebelement(String elementName) {
        return blkSearchResultItem;
    }

    @Override
    public String getPageLink() {
        return "http://www.amazon.com";
    }

}
