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

 private static final WebDriver driver=DriverHooks.getDriver();
    static WebDriverWait wait;

    @Given("I navigate to the URL {string}")
    public void navigateToURL(String url) {
        driver.get(url);
    }
    @Then("I wait for {int} milliseconds")
    public void waitForMilliseconds(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    public static WebElement getElement(By locator)
    {
         wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Max wait time: 10 seconds
         wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
         return driver.findElement(locator);
    }

}
