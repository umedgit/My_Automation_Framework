package stepdefinitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.Pom_Abstract;

public class Stp_AddUpdateDeleteAddress {

    private Pom_Abstract pomPage = Stp_PomPageSwitch.getPomPage();

    @Then("^\"([^\"]*)\" form should display$")
    public void formShouldDisplay(String formName){
        String actualFormName = pomPage.getElementText("Form title");
        Assert.assertEquals(actualFormName, formName);
    }

    @Then("^new address with Address title \"([^\"]*)\" should display$")
    public void newAddressWithAddressTitleShouldDisplay(String titleName) {
        boolean contains =false;
        for (WebElement element : pomPage.getListOfWebelement("Address Subheading")) {
            if (element.getText().equalsIgnoreCase(titleName)){
                contains = true;
            }
        }
        Assert.assertTrue(contains);
    }
}
