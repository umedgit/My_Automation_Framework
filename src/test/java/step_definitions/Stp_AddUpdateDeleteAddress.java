package step_definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pom.PomPageFactory;
import pom.Abstract_PomPage;
import utilities.DriverSingleton;

public class Stp_AddUpdateDeleteAddress {

    private Abstract_PomPage pomPage = PomPageFactory.getPomPage();

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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addressBlock));

        Assert.assertFalse(containsTitle(titleName));
    }

    private boolean containsTitle(String title) {
        for (WebElement element : pomPage.getListOfWebelement("Address Subheading")) {
            if(element.getText().equalsIgnoreCase(title)) return true;
        }
        return false;
    }
}
