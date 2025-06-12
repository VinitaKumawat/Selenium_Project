package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.CartPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.time.Duration;

public class CartSteps {
    WebDriver driver;
    CartPage cartPage;

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
        cartPage = new CartPage(driver);
    }

    @When("I select a product {string}")
    public void i_select_a_product(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        driver.findElement(By.cssSelector("a.btn-success")).click();
     // Wait for the alert to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.alertIsPresent()); // Wait for alert
            Alert alert = driver.switchTo().alert(); // Switch to alert
            alert.accept(); // Accept alert
        } catch (Exception e) {
            System.out.println("No alert appeared after clicking 'Add to Cart'");
        }
    }

    @When("I navigate to the cart page")
    public void i_navigate_to_the_cart_page() {
        cartPage.navigateToCart();
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        cartPage.proceedToCheckout();
    }

    @When("I enter order details {string} {string} {string} {string} {string} {string}")
    public void i_enter_order_details(String name, String country, String city, String card, String month, String year) {
        cartPage.enterOrderDetails(name, country, city, card, month, year);
    }

    @When("I confirm the purchase")
    public void i_confirm_the_purchase() {
        cartPage.confirmPurchase();
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        Assert.assertTrue(cartPage.isOrderConfirmed());
        driver.quit();
    }
}
