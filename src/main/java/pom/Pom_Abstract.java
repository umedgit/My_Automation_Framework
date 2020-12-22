package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.util.List;
import java.util.Random;

// creating abstract POM class in order to be able to reuse in Steps definitions and to switch between
// pages.
public abstract class Pom_Abstract {

    WebDriver driver = Driver.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    abstract void setWebElement(String elementName);
    public abstract void clickFunction(String elementName);
    public abstract void sendKeysFunction(String elementName, String text);
    public abstract String getElementText(String elementName);
    public abstract void selectRandomDropDown(String elementName);
    public abstract List<WebElement> getListOfWebelement(String elementName);
    public abstract void clickBtnUnderAddressBlock(String parentElement, String childElement);
    public abstract String getPageLink();


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

    private void scrollIntoElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    void selectRandomDropDown(WebElement elementName){
        Select dropDown = new Select(elementName);
        Random random = new Random();
        dropDown.selectByIndex(random.nextInt(dropDown.getOptions().size()-1)+1);
    }


}
