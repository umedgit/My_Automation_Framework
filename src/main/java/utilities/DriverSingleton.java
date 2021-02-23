package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    //creating ThreadLocal Webdriver in order to be able to run tests in different browsers in parallel.
    //
    private DriverSingleton(){}
    private static ThreadLocal<WebDriver> threadWebDriver = new ThreadLocal<>();

    public static void setWebDriver(String browserName){

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
        // adding condition to run scenario directly without runners.
        if (threadWebDriver.get()==null) setWebDriver(null);
        return threadWebDriver.get();
    }

    public static void quitWebDriver(){
        if (threadWebDriver.get()!=null){
            threadWebDriver.get().quit();
            threadWebDriver.set(null);
        }
    }

}