package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.Driver;


@CucumberOptions
        (
                features = {"src/test/java/feature_files"},
                glue = {"step_definitions"}
        )


public class AllStepsRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browser")
    public void beforeMethod(String browser){
        Driver.setThreadWebDriver(browser);
    }
}
