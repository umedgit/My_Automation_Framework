package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.Pom_Abstract;

import java.util.List;

public class Stp_UpdateFirstLastName {
    private Pom_Abstract pom_page = Stp_1PomPageSwitch.getPomPage();

    @When("^under \"([^\"]*)\" address click on \"([^\"]*)\"$")
    public void under_address_click_on(String parentElement, String childElement)  {
        pom_page.clickBtnUnder(parentElement, childElement);
    }


    @Then("^under \"([^\"]*)\" block \"([^\"]*)\" should display$")
    public void underBlockShouldDisplay(String addressTitle, String name)  {
        List<WebElement> lstAddressBlk = pom_page.getListOfWebelement("Address block");
        boolean contains=false;

        for(WebElement element: lstAddressBlk){
            if(element.getText().contains(addressTitle.toUpperCase()) &&
                    element.getText().contains(name)) {
                contains=true;
            }
        }
        Assert.assertTrue(contains);
    }
}

