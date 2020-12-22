package step_definitions;

import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    @After //After each scenario
    public void after(Scenario scenario){
        if(scenario.isFailed()){
            //Getting scenario name and formatting it by adding "_" instead of space
            String scenarioName = scenario.getName().replaceAll(" ", "_");

            //adding time and formatting the time
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy_mm_dd_HH_mm_ss");
            String timeStamp = dateFormat.format(new Date());

            //Taking screenshot using selenium library and saving into png File by adding scenrio name
            TakesScreenshot screenshot = ((TakesScreenshot)Driver.getWebDriver());
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("target/extent_reports/screenshots/" + scenarioName
                    + "_"+ timeStamp+".png");

            try {
                FileUtils.copyFile(sourceFile,destinationFile);
                Reporter.addScreenCaptureFromPath("screenshots/" + scenarioName + "_"
                        + timeStamp+".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
