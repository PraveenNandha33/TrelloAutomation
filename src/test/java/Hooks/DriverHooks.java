package Hooks;

import Drivers.WebAppDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DriverHooks {

   private static WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        String browserType="chrome";
        WebAppDriverManager webAppDriverManager = new WebAppDriverManager();
        if(scenario.getSourceTagNames().contains("@fireFox")) {
           browserType="firefox";
        }
        else if(scenario.getSourceTagNames().contains("@MSEdge")){
            browserType="msedge";
        }
        driver = webAppDriverManager.getWebDriver(browserType);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver;
    }

    @After
    public void teardown() {
        WebAppDriverManager.quitDriver();
    }

}
