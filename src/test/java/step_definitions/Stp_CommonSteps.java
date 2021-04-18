package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.BasePage;
import utilities.DriverSingleton;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Stp_CommonSteps {
    BasePage pomPage;
    private WebDriver driver = DriverSingleton.getWebDriver();

    @Given("^navigate to \"([^\"]*)\"$")
    public void navigate_to(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^user is on \"([^\"]*)\"$")
    public void userIsOn(String pageName) {
        BasePage.setPageName(pageName);
        pomPage = BasePage.getInstance();
    }

    @When("^click on \"([^\"]*)\"$")
    public void click_on(String elementName) {
        pomPage.clickOn(elementName);
    }

    @And("^randomly select an option from the \"([^\"]*)\" dropdown list$")
    public void randomlySelectAnOptionFromTheDropdownList(String elementName) {
        pomPage.selectRandomFromDropDown(elementName);
    }

    @When("^fill the form text fields as below:$")
    public void fill_the_form_text_fields_as_below(DataTable dataTable) {

        Map<String, String> elementsAndValue = dataTable.asMap(String.class, String.class);

        for (Map.Entry<String, String> element: elementsAndValue.entrySet()) {
            pomPage.typeIn(element.getKey(), element.getValue());
        }
    }

    @And("^click on \"([^\"]*)\" on alert$")
    public void clickOnOnAlert(String arg)  {
        if (arg.equalsIgnoreCase("yes") || arg.equalsIgnoreCase("ok")){
            driver.switchTo().alert().accept();
        }
        else driver.switchTo().alert().dismiss();
    }
}
