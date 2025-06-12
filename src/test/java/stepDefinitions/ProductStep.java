package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Product;


public class ProductStep {
    WebDriver driver;
    Product homePage;

    @Given("I am on the demoblaze homepage")
    public void i_am_on_the_demoblaze_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
        homePage = new Product(driver);
    }

    
    @When("I click on the product")
    public void i_click_on_the_product() {
    	
    	homePage.clickOnProduct();
    	
    }

    @When("I click on the add to cart")
    public void i_click_on_the() {
        homePage.clickAddToCart1(); 
    }

    @Then("I should see an alert popup with the message {string}")
    public void i_should_see_an_alert_popup_with_the_message(String expectedAlertMessage) {
    	
        String actualAlertMessage = homePage.handleAlertAndGetMessage();

        if (!actualAlertMessage.equals(expectedAlertMessage)) {
        	
            throw new AssertionError("Expected: " + expectedAlertMessage + ", but got: " + actualAlertMessage);
        }
    }
    
    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}