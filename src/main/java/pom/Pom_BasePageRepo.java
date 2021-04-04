package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSingleton;

import java.io.IOException;
import java.util.Random;

public class Pom_BasePageRepo {

    WebDriver driver = DriverSingleton.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private static RepositoryParser parser;
    private static ThreadLocal<Pom_BasePageRepo> instance = new ThreadLocal<>();

    public static void setPageName(String pageName){
        try{
            parser = new RepositoryParser("src/main/resources/PageObjects.xls", pageName);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Pom_BasePageRepo getInstance(){
        if(instance.get()==null){
            instance.set(new Pom_BasePageRepo());
        }
        return instance.get();
    }

    ////////////////////////////////////////////////////
    // Local Reusable Methods
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

    //This function is used to get Locators from PageObjects.properties file from RepositoryParser
    private WebElement getWebElement(String elementName){
        return driver.findElement(parser.getObjectLocator(elementName));
    }


    ////////////////////////////////////////////////////
    // Public Methods for Step definitions
    ///////////////////////////////////////////////////

    public void clickOn(String elementName){
        waitScrollClickFunction(getWebElement(elementName));
    }

    public void doubleClickOn(String elementName){

    }

    public void rightClickOn(String elementName){

    }

    public void typeIn(String elementName, String text) {
        waitClearSendKeysFunction(getWebElement(elementName), text);
    }

    public String getElementText(String elementName) {
        return getWebElement(elementName).getText();
    }

    public void selectFromDropDown(String elementName){

    }

    public void selectRandomFromDropDown(String elementName) {
        selectRandomDropDown(getWebElement(elementName));
    }

    //This function is currently related to My Addresses page
    public void clickBtnUnderAddressBlock(String parentElement, String childElement) {

//        WebElement element = driver.findElement(By.xpath("//h3[text()='New Address']//ancestor::ul//a[@title='Update']"));

        WebElement element = driver.findElement(By.xpath("//h3[text()='" + parentElement +
                "']//ancestor::ul//a[@title='" + childElement + "']"));

        waitScrollClickFunction(element);
    }

}
