package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSingleton;

import java.util.List;
import java.util.Random;

// creating abstract POM class in order to be able to reuse in Steps definitions and to switch between
// pages.
public abstract class Abstract_PomPage {

    WebDriver driver = DriverSingleton.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);


    //This class provides access to the functions and actions below which are called from the step definitions.
    //The webelements are taken from the child classes.
    abstract WebElement getWebElement(String elementName);
    public abstract List<WebElement> getListOfWebelement(String elementName);
    public abstract String getPageLink();

    public abstract void clickFunction(String elementName);
    public abstract void sendKeysFunction(String elementName, String text);
    public abstract String getElementText(String elementName);
    public abstract void selectRandomFromDropDown(String elementName);

    ///////////////////////////////////////////////////////////////
    // Reusable functions
    ///////////////////////////////////////////////////////////////

    private void scrollIntoElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    void waitScrollClickFunction(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollIntoElement(element);
        element.click();
    }

    void waitClearSendKeysFunction(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollIntoElement(element);
        element.clear();
        element.sendKeys(text);
    }

    void selectRandomDropDown(WebElement elementName){
        Select dropDown = new Select(elementName);
        Random random = new Random();
        dropDown.selectByIndex(random.nextInt(dropDown.getOptions().size()-1)+1);
    }


}
