package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //creating ThreadLocal Webdriver in order to be able to run tests in different browsers in parallel.
    //
    private static ThreadLocal<WebDriver> threadWebDriver = new ThreadLocal<>();

    public static void setThreadWebDriver(String browserName){

        if (browserName==null || browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            threadWebDriver.set(new ChromeDriver());
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            threadWebDriver.set(new FirefoxDriver());
        }
        else throw new RuntimeException("No such web driver");

    }

    public static WebDriver getWebDriver(){
        return threadWebDriver.get();
    }

}