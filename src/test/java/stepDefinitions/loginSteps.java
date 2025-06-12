package stepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObject.LoginPage;
import java.time.Duration;

public class loginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I open the Demoblaze website")
    public void i_open_the_demoblaze_website() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login submit button")
    public void i_click_the_login_submit_button() {
        loginPage.clickLoginSubmit();
    }

    @Then("I should see a successful login message")
    public void i_should_see_a_successful_login_message() {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful!");
        driver.quit();
    }
    @Then("I should see an error message")
    public void i_should_see_an_error_message_and_handle_the_alert() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert displayed: " + alertText);
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert found.");
        }
        loginPage.clickCloseButton();
        driver.quit();
    }
}
