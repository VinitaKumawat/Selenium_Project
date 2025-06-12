package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUp {
    WebDriver driver;

    public SignUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    private By signUpSection = By.id("signin2");
    private By usernameField = By.xpath("//input[@id='sign-username']");
    private By passwordField = By.xpath("//input[@id='sign-password']");
    private By signUpButton = By.xpath("//button[normalize-space()='Sign up']");

    // Methods
    public void clickOnSignUpSection() {
        driver.findElement(signUpSection).click();
    }

    public void enterSignUpDetails(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public String handleAlertAndGetMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept(); 

        return alertMessage;
    }
}
