package StepDefinitions;

import Hooks.DriverHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static StepDefinitions.CommonStepDefinitions.getElement;
import static StepDefinitions.CommonStepDefinitions.waitForMilliseconds;

public class LoginStepDefinitions {

    private WebDriver driver;
    public LoginStepDefinitions(DriverHooks hooks){
        this.driver= hooks.getDriver();
    }

    By homePageLogin=By.linkText("Log in");
    By usernameField=By.id("user");
    By continueBtn=By.id("login");
    By passwordField=By.id("password");
    By loginButton=By.id("login-submit");
    By profile=By.xpath("//button[@data-testid='header-member-menu-button']");
    By dashboardLogout=By.xpath("//button[@data-testid='account-menu-logout']");
    By confirmLogout=By.id("logout-submit");

    @Then("I click on login button")
    public void iClickOnLoginButton() {
        driver.findElement(homePageLogin).click();
    }

    @Given("I enter the value {string} in the username field and click on continue button")
    public void iEnterTheUserName(String userName) {
        driver.findElement(usernameField).sendKeys(userName);
        driver.findElement(continueBtn).click();
    }

    @Then("I enter the password {string} and click on login button")
            public void iEnterPasswordandClickonContinue(String password){
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(loginButton).click();
    }

    @Given("^I enter username \"([^\"]*)\" and password \"([^\"]*)\" and click on login button$")
    public void enterUsernameAndPasswordAndClickLogin(String userName, String password) throws InterruptedException {
        getElement(usernameField).sendKeys(userName);
        getElement(continueBtn).click();
        waitForMilliseconds(2000);
        getElement(passwordField).sendKeys(password);
        getElement(loginButton).click();
    }

    @Then("I logout from the application")
    public void logout(){
        getElement(profile).click();
        getElement(dashboardLogout).click();
        getElement(confirmLogout).click();
    }

}
