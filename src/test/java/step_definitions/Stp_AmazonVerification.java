package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.Abstract_PomPage;
import pom.PomPageFactory;
import utilities.DriverSingleton;

import java.util.List;

public class Stp_AmazonVerification {
    private Abstract_PomPage pomPage = PomPageFactory.getPomPage();
    private WebDriver driver = DriverSingleton.getWebDriver();

    @Then("^a list of items should display$")
    public void list_of_items_with_prices_should_display() {
        Assert.assertTrue(pomPage.getListOfWebelement("Search item").size()>0);
    }

    @When("^user gets the price and clicks on the first item on the list$")
    public void userClicksOnTheFirstItemOnTheList() {
        WebElement element = pomPage.getListOfWebelement("Search item").get(0);
        String price = element.findElement(By.cssSelector("span[class='a-offscreen']")).getAttribute("innerHTML");

        List<WebElement> list = element.findElements(By.cssSelector("span[class='a-offscreen']"));

        for (WebElement webElement : list) {
            System.out.println(webElement.getAttribute("innerHTML"));
        }

        System.out.println("price="+ price);
        element.click();

        Assert.assertEquals(pomPage.getElementText("Item price"), price);
    }
}
