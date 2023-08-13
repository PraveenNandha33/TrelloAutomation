package StepDefinitions;

import Hooks.DriverHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonStepDefinitions {

    private static WebDriver driver;

    public CommonStepDefinitions(DriverHooks hooks) {
        this.driver = hooks.getDriver();
    }

    static WebDriverWait wait;

    @Given("I navigate to the URL {string}")
    public void navigateToURL(String url) {

        driver.get(url);
    }

    @Then("I wait for {int} milliseconds")
    public static void waitForMilliseconds(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    /**
     * This method wait for a specific element to become visible on a web page
     * @param locator
     */
    public static void iwaitTillElementLoads(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * This method will wait till the element loads and is used to locate and return a web element on a web page based on the provided locator
     * @param locator
     * @return
     */
    public static WebElement getElement(By locator) {
        iwaitTillElementLoads(locator);
        return driver.findElement(locator);
    }

}
