package step_definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.Pom_Abstract;
import utilities.Driver;

public class Stp_AddUpdateDeleteAddress {

    private Pom_Abstract pomPage = Stp_1PomPageSwitch.getPomPage();
    private WebDriver driver = Driver.getWebDriver();

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
        Assert.assertFalse(containsTitle(titleName));
    }

    private boolean containsTitle(String title) {
        for (WebElement element : pomPage.getListOfWebelement("Address Subheading")) {
            if(element.getText().equalsIgnoreCase(title)) return true;
        }
        return false;
    }
}
