package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pom_LoginPage extends Abstract_PomPage {

    public Pom_LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //=====================Login Page Elements==================//
    @FindBy(linkText = "Sign in")
    private WebElement lnkSignIn;
    @FindBy(id = "email")
    private WebElement txtEmail;
    @FindBy(id = "passwd")
    private WebElement txtPassword;
    @FindBy(id = "SubmitLogin")
    private WebElement btnSignIn;
    @FindBy(linkText = "Sign out")
    private WebElement lnkSignOut;

    //====================Abstract Methods code==================//

    private WebElement webElement;

    @Override
    void setWebElement(String elementName) {
        switch (elementName) {
            case "Sign In link":         webElement = lnkSignIn;     break;
            case "Sign Out link":        webElement = lnkSignOut;    break;
            case "Sign In button":       webElement = btnSignIn;     break;
            case "email field":          webElement = txtEmail;      break;
            case "password field":       webElement = txtPassword;   break;
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
        return null;
    }

    @Override
    public void selectRandomFromDropDown(String elementName) {
    }

    @Override
    public List<WebElement> getListOfWebelement(String elementName) {
        return null;
    }

    @Override
    public String getPageLink() {
        return "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    }

}
