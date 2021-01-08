package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pom.PomPageFactory;
import pom.Abstract_PomPage;
import utilities.DriverSingleton;

public class Stp_VerifyLogin {

    private Abstract_PomPage pomPage = PomPageFactory.getPomPage();
    private WebDriver driver = DriverSingleton.getWebDriver();

    @When("^enter username and password$")
    public void enter_username_and_password() {
        pomPage.sendKeysFunction("email field", "yosiftakhi@gmail.com");
        pomPage.sendKeysFunction("password field", "Pa$$word$");
    }

    @Then("^user should login successfully$")
    public void user_should_login_successfully() {
        Assert.assertEquals(driver.getCurrentUrl(), ("http://automationpractice.com/index.php?controller=my-account"));
    }

}
