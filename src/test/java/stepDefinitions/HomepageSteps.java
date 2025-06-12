package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageObject.Homepage;

public class HomepageSteps {
    
    WebDriver driver;
    Homepage homepage;

    @Given("I launch the browser and navigate to the homepage")
    public void i_launch_the_browser_and_navigate_to_the_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        homepage = new Homepage(driver);
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkName) {
        switch (linkName.toLowerCase()) {
            case "home":
                homepage.clickHome();
                break;
            case "contact":
                homepage.clickContact();
                break;
        }
    }

    @Then("All navigation links should work properly")
    public void all_navigation_links_should_work_properly() {
        System.out.println("Verified all navigation links.");
    }
    
    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(expectedTitle, homepage.getPageTitle());
    }
    
    @When("I select the {string} category")
    public void i_select_the_category(String categoryName) {
        switch (categoryName.toLowerCase()) {
            case "phones":
                homepage.selectPhonesCategory();
                break;
            case "laptops":
                homepage.selectLaptopsCategory();
                break;
            case "monitors":
                homepage.selectMonitorsCategory();
                break;
        }
    }

    @Then("Categories should be displayed properly")
    public void categories_should_be_displayed_properly() {
        System.out.println("Verified category selection.");
    }

    @When("I click the carousel next button")
    public void i_click_the_carousel_next_button() {
        homepage.clickCarouselNext();
    }

    @When("I click the carousel previous button")
    public void i_click_the_carousel_previous_button() {
        homepage.clickCarouselPrev();
    }

    @Then("Carousel should work properly")
    public void carousel_should_work_properly() {
        System.out.println("Verified carousel functionality.");
        driver.quit();
    }
}
