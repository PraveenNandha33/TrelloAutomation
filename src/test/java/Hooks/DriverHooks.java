package Hooks;

import Drivers.WebAppDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DriverHooks {

   private static WebDriver driver;


    @Before
    public void setup() {
        WebAppDriverManager webAppDriverManager=new WebAppDriverManager();
        driver=webAppDriverManager.getWebDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    @After
    public void teardown() {
        WebAppDriverManager.quitDriver();
    }

}
