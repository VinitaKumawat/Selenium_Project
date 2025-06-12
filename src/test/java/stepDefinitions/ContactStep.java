package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageObject.Contact;

public class ContactStep {
    WebDriver driver;
    Contact contact;

    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }

    @Given("I am on the Demoblaze homepage")
    public void i_am_on_the_demoblaze_homepage() {
        setup();
        contact = new Contact(driver);
    }

    @When("I click on the Contact option")
    public void i_click_on_the_contact_option() {
        contact.clickOnContactSection();
    }

    @When("I enter {string} in the contact email field")
    public void i_enter_in_the_contact_email_field(String email) {
        contact.enterEmail(email);
    }

    @When("I enter {string} in the contact name field")
    public void i_enter_in_the_contact_name_field(String name) {
        contact.enterName(name);
    }

    @When("I enter {string} in the message field")
    public void i_enter_in_the_message_field(String message) {
        contact.enterMessage(message);
    }

    @When("I click on the Send message button")
    public void i_click_on_the_send_message_button() {
        contact.clickSendMessageButton();
    }

    @Then("I should see an alert with the message {string}")
    public void i_should_see_an_alert_with_the_message(String expectedAlert) {
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        Assert.assertEquals(expectedAlert, actualMessage);
        alert.accept(); // Close the alert
        driver.quit();
    }
}
