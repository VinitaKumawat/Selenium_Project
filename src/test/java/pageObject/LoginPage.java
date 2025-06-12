package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginSubmitButton;

    @FindBy(id = "nameofuser")  // Element that appears when login is successful
    private WebElement welcomeMessage;

    @FindBy(xpath = "//div[@class='modal fade show']//div[contains(text(),'Wrong password.')]")
    private WebElement errorMessage;
    
    @FindBy(xpath = "(//button[text()='Close'])[3]")
    private WebElement closeButton;

    // Actions
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void clickLoginSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton)).click();
        handleUnexpectedAlert();
    }

    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.visibilityOf(welcomeMessage)).isDisplayed();
    }

    public boolean isLoginErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
    }

    private void handleUnexpectedAlert() {
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            alertWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Unexpected alert found: " + alert.getText());
            alert.accept();
        } catch (TimeoutException e) {
            // No alert appeared, continue execution
        }
    }
    public void clickCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }
}
