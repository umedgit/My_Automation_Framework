package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSingleton;

import java.util.Random;

public class Pom_HasA {

    WebDriver driver = DriverSingleton.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private  WebElement webElement;

    ////////////////////////////////////////////////////
    // Class Reusable Methods
    ///////////////////////////////////////////////////

    private void scrollIntoElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    private void waitScrollClickFunction(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollIntoElement(element);
        element.click();
    }

    private void waitClearSendKeysFunction(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollIntoElement(element);
        element.clear();
        element.sendKeys(text);
    }

    private void selectRandomDropDown(WebElement elementName){
        Select dropDown = new Select(elementName);
        Random random = new Random();
        dropDown.selectByIndex(random.nextInt(dropDown.getOptions().size()-1)+1);
    }

    private void setWebElement(String elementName){
        webElement = PomPageFactory.getPomPage().getWebElement(elementName);
    }

    ////////////////////////////////////////////////////
    // Public Methods for Step definitions
    ///////////////////////////////////////////////////

    public void clickFunction(String elementName){
        setWebElement(elementName);
        waitScrollClickFunction(webElement);
    }


    public void sendKeysFunction(String elementName, String text) {
        setWebElement(elementName);
        waitClearSendKeysFunction(webElement, text);
    }

    public String getElementText(String elementName) {
        setWebElement(elementName);
        return webElement.getText();
    }

    public void selectRandomFromDropDown(String elementName) {
        setWebElement(elementName);
        selectRandomDropDown(webElement);
    }

    public void clickBtnUnderAddressBlock(String parentElement, String childElement) {

//        WebElement element = driver.findElement(By.xpath("//h3[text()='New Address']//ancestor::ul//a[@title='Update']"));

        WebElement element = driver.findElement(By.xpath("//h3[text()='" + parentElement +
                "']//ancestor::ul//a[@title='" + childElement + "']"));

        waitScrollClickFunction(element);
    }

}
