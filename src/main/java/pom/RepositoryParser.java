package pom;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


//In this class we are going to map the PageObjects.properties locatorTypes and Values
//The object of this class is created in Pom_Base_Page
public class RepositoryParser {

    private Properties propertyFile = new Properties();

    public RepositoryParser(String filePath) throws IOException
    {
        FileInputStream stream = new FileInputStream(filePath);
        propertyFile.load(stream);
    }

    //This function is requested from Pom_BasePage in order to get WebElements By object
    public By getObjectLocator(String locatorName)
    {
        //Here I am removing all spaces from the element name and replacing by "_"
        // as key element in properties file cannot have a space
        String normalizedLocatorName = locatorName.trim().replaceAll("\\s", "_");
        String locatorProperty = propertyFile.getProperty(normalizedLocatorName);

        String locatorType = locatorProperty.split(":")[0];
        String locatorValue = locatorProperty.split(":")[1];

        By locator = null;
        switch(locatorType)
        {
            case "id":              locator = By.id(locatorValue);              break;
            case "name":            locator = By.name(locatorValue);            break;
            case "cssSelector":     locator = By.cssSelector(locatorValue);     break;
            case "linkText":        locator = By.linkText(locatorValue);        break;
            case "partialLinkText": locator = By.partialLinkText(locatorValue); break;
            case "tagName":         locator = By.tagName(locatorValue);         break;
            case "xpath":           locator = By.xpath(locatorValue);           break;
        }
        return locator;
    }
}
