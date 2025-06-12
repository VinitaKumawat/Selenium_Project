package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.SignUp;

public class SignUpStep {
    WebDriver driver;
    SignUp signUpPage;
    String generatedUsername;

    @Given("I am on the demoBlaze homepage")
    public void i_am_on_the_demoBlaze_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
        signUpPage = new SignUp(driver);
    }

    @When("I click on the Sign Up option")
    public void i_click_on_the_sign_up_option() {
        signUpPage.clickOnSignUpSection();
    }

    @When("I enter a unique username and password")
    public void i_enter_a_unique_username_and_password() {
        generatedUsername = "testUser_" + System.currentTimeMillis();  // Generate unique username
        signUpPage.enterSignUpDetails(generatedUsername, "Test@1234");
    }

    @When("I click on the Sign Up button")
    public void i_click_on_the_sign_up_button() {
        signUpPage.clickOnSignUpButton();
    }

    @Then("an alert message should popup confirming sign-up or user existence")
    public void an_alert_message_should_popup_confirming_sign_up_or_user_existence() {
        String actualAlertMessage = signUpPage.handleAlertAndGetMessage();

        if (actualAlertMessage.contains("This user already exist.")) {
            System.out.println("User already exists, retrying with a different username.");
        } else if (actualAlertMessage.contains("Sign up successful.")) {
            System.out.println("Sign up successful for: " + generatedUsername);
        } else {
            throw new AssertionError("Unexpected alert message: " + actualAlertMessage);
        }
        driver.quit();
    }
}
