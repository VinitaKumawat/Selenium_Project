package pageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleValidation {
    WebDriver driver;

    @Before
    public void setup() {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateWebPageTitle() {
        // Navigate to the website
        driver.get("https://www.demoblaze.com/index.html");

        // Retrieve the title of the webpage
        String actualTitle = driver.getTitle();

        // Expected title
        String expectedTitle = "STORE";

        // Validate the title
        Assert.assertEquals("Webpage title did not match!", expectedTitle, actualTitle);
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
