package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.DriverSingleton;


@CucumberOptions
        (
                features = {"src/test/java/feature_files"},
                tags = {"@SmokeTest"},
                glue = {"step_definitions"}
        )


public class SmokeTestsRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browser")
    public void beforeMethod(String browser){
        DriverSingleton.setThreadWebDriver(browser);
    }

    @AfterClass
    public void afterSmokeTest(){
        DriverSingleton.quitDriver();
    }
}
