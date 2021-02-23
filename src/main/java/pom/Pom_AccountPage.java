package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pom_AccountPage extends Pom_AbstractPage {

    public Pom_AccountPage() {
        PageFactory.initElements(driver, this);
    }



    //====================My Account Elements====================//
    @FindBy(css = "a[title='Addresses']")
    private WebElement btnMyAddresses;


    private WebElement webElement;

    @Override
    public WebElement getWebElement(String elementName) {
        switch (elementName) {
            case "My addresses button":       webElement = btnMyAddresses;      break;
        }
        return webElement;
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
