package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSingleton;

import java.util.List;
import java.util.Random;

public class Pom_BasePage {

    WebDriver driver = DriverSingleton.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private Pom_AbstractPage pomPage = PomPageFactory.getPomPage();

    ////////////////////////////////////////////////////
    // Class Reusable Methods
    ///////////////////////////////////////////////////

    private void scrollIntoElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    private void waitScrollClickFunction(WebElement elementName){
        wait.until(ExpectedConditions.elementToBeClickable(elementName));
        scrollIntoElement(elementName);
        elementName.click();
    }

    private void waitClearSendKeysFunction(WebElement elementName, String text){
        wait.until(ExpectedConditions.visibilityOf(elementName));
        scrollIntoElement(elementName);
        elementName.clear();
        elementName.sendKeys(text);
    }

    private void selectRandomDropDown(WebElement elementName){
        Select dropDown = new Select(elementName);
        Random random = new Random();
        dropDown.selectByIndex(random.nextInt(dropDown.getOptions().size()-1)+1);
    }


    ////////////////////////////////////////////////////
    // Public Methods for Step definitions
    ///////////////////////////////////////////////////

    public void clickFunction(String elementName){
        waitScrollClickFunction(pomPage.getWebElement(elementName));
    }

    public void sendKeysFunction(String elementName, String text) {
        waitClearSendKeysFunction(pomPage.getWebElement(elementName), text);
    }

    public String getElementText(String elementName) {
        return pomPage.getWebElement(elementName).getText();
    }

    public void selectRandomFromDropDown(String elementName) {
        selectRandomDropDown(pomPage.getWebElement(elementName));
    }

    public void clickBtnUnderAddressBlock(String parentElement, String childElement) {

//        WebElement element = driver.findElement(By.xpath("//h3[text()='New Address']//ancestor::ul//a[@title='Update']"));

        WebElement element = driver.findElement(By.xpath("//h3[text()='" + parentElement +
                "']//ancestor::ul//a[@title='" + childElement + "']"));

        waitScrollClickFunction(element);
    }

    public List<WebElement> getListOfWebelement(String elementName){
        return pomPage.getListOfWebelement(elementName);
    }

}
