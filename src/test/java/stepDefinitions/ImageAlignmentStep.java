package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.ImageAlignment;

import java.time.Duration;

public class ImageAlignmentStep {
    WebDriver driver;
    ImageAlignment imageverify;

    @Given("User on the demoBlaze homepage")
    public void i_am_on_the_demoBlaze_homepage() {
      
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
  
        imageverify = new ImageAlignment(driver);
    }

    // Step to verify the alignment of product images
    @When("I verify the alignment of product images")
    public void i_verify_the_alignment_of_product_images() {
       
        boolean isAligned = imageverify.verifyImageAlignment();
        
        System.out.println("Product images is aligned: " + isAligned);
        
        if (!isAligned) {
           
            throw new AssertionError("Product images are not properly aligned.");
        }
    }

    @Then("all product images should be properly aligned and consistent")
    public void all_product_images_should_be_properly_aligned_and_consistent() {
      
        boolean areSizesConsistent = imageverify.verifyImageSizes();
        
        System.out.println("Product images is consistent: " + areSizesConsistent);
        
        if (!areSizesConsistent) {
           
            throw new AssertionError("Product images do not have consistent sizes.");
               
        }
    }
    
    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    
}
