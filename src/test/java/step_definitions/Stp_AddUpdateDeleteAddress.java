package step_definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pom.Abstract_PomPage;
import pom.PomPageFactory;
import utilities.DriverSingleton;

public class Stp_AddUpdateDeleteAddress {

    private Abstract_PomPage pomPage = PomPageFactory.getPomPage();
    WebDriver driver = DriverSingleton.getWebDriver();

    @Then("^\"([^\"]*)\" form should display$")
    public void formShouldDisplay(String formName){
        String actualFormName = pomPage.getElementText("Form title");
        Assert.assertEquals(actualFormName, formName);
    }

    @Then("^new address with Address title \"([^\"]*)\" should display$")
    public void newAddressWithAddressTitleShouldDisplay(String titleName) {
        Assert.assertTrue(containsTitle(titleName));
    }

    @Then("^address block \"([^\"]*)\" should be removed from the page$")
    public void addressBlockShouldBeRemovedFromThePage(String titleName) {

        WebDriverWait wait = new WebDriverWait(DriverSingleton.getWebDriver(),4);
        By addressBlock = By.xpath("//h3[text()='" + titleName + "']");
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(addressBlock)));

    }

    private boolean containsTitle(String title) {
        for (WebElement element : pomPage.getListOfWebelement("Address Subheading")) {
            if(element.getText().equalsIgnoreCase(title)) return true;
        }
        return false;
    }
}
