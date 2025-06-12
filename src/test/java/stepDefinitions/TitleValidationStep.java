package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pageObject.TitleValidation;

import org.junit.Assert;

public class TitleValidationStep {
    WebDriver driver;

    TitleValidation titlevalidation;
    
   // titlevalidation = new TitleValidation(driver);
    @Given("I open the demoBlaze website")
    public void i_open_the_demoBlaze_website() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }

    @Then("the title of the webpage should be {string}")
    public void the_title_of_the_webpage_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle + " is title of the Web Page");
        Assert.assertEquals("Webpage title did not match!", expectedTitle, actualTitle);
        driver.quit();
    }
}