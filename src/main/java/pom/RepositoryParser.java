package pom;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;


//In this class we are going to map the PageObjects.properties locatorTypes and Values
//The object of this class is created in Pom_Base_Page
public class RepositoryParser {

    Sheet pageSheet;

    public RepositoryParser(String filePath, String pageName) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        pageSheet = workbook.getSheet(pageName);
    }

    //This function is requested from Pom_BasePage in order to get WebElements By object
    public By getObjectLocator(String locatorName)
    {
        Row row;
        String locatorType = null, locatorValue = null;
        int rowCount = pageSheet.getPhysicalNumberOfRows();

        for (int i=1; i < rowCount; i++){
            row = pageSheet.getRow(i);

            if (row.getCell(1).toString().equalsIgnoreCase(locatorName)){
                locatorType = row.getCell(3).toString();
                locatorValue = row.getCell(4).toString();
                break;
            }
        }

        By locator = null;
        if (locatorType!=null){
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
        }
        return locator;
    }
}
