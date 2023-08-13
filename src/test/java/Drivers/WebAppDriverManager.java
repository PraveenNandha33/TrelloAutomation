package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class WebAppDriverManager {

    public static WebDriver driver;

    /**
     * This method creates the webdriver instance for chrome browser and return it to the setup method
     * @return
     */
    public WebDriver getWebDriver(String browserType) {
        if(driver==null) {
            if(browserType.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if(browserType.equals("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
            }
            else if(browserType.equals("msedge")){
                WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
