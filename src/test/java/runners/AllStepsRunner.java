package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.DriverSingleton;


@CucumberOptions
        (       plugin = {"pretty",
                "html:target/cucumber-Html-Report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/extent_reports/TestExecutionReport.html"
                        },
                features = {"src/test/java/feature_files"},
                glue = {"step_definitions"}
        )


public class AllStepsRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browser")
    public void beforeMethod(String browser){
        DriverSingleton.setThreadWebDriver(browser);
    }

    @AfterClass
    void afterClass(){
        Reporter.loadXMLConfig("src/test/java/feature_files/extentReports.xml");
        Reporter.setSystemInfo("My Automation Framework", "12/2020");
        Reporter.setSystemInfo("OS", System.getProperty("os.name"));
        Reporter.setSystemInfo("Environment", "QA");


        //closing the browser in thread
        DriverSingleton.quitDriver();
    }
}
