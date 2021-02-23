package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSingleton;

import java.util.List;

// creating abstract POM class in order to be able to reuse in Steps definitions and to switch between
// pages.
public abstract class Pom_AbstractPage {

    WebDriver driver = DriverSingleton.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);


    //This class provides access to the functions and actions below which are called from the step definitions.
    //The webelements are taken from the child classes.
    public abstract WebElement getWebElement(String elementName);
    public abstract List<WebElement> getListOfWebelement(String elementName);
    public abstract String getPageLink();

}
