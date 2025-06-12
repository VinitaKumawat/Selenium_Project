package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Logout;


public class LogoutStep {

    WebDriver driver;
    Logout logout;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

        logout = new Logout(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("user launch browser and navigate to the login page")
    public void i_launch_browser_and_navigate_to_the_login_page() {
        driver.get("https://www.demoblaze.com/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logout.loginSection)); 
    }

    @When("user click on the Log in section")
    public void i_clicked_on_log_in_sectionn() {
        logout.loginButton();
    }

    @When("User enter valid username {string} into username field")
    public void i_enter_valid_username_into_username_field(String string) {
        logout.setUsername(string);
    }

    @And("User enter valid password {string} into password field")
    public void i_enter_valid_password_into_password_field(String string) {
        logout.setPassword(string);
    }

    @And("User click on login button")
    public void i_click_on_login_button() {
        logout.clickOnLogin();
    }

    @Then("User successfully login")
    public void i_successfully_login() {
        Assert.assertTrue(driver.getCurrentUrl().contains("index.html"));
    }
    
    @Then("I click on logout option")
    public void i_click_on_logout_option() {
       logout.logoutButton();
       driver.quit();
    }
}