package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contact {
    WebDriver driver;
    
    public Contact(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//a[normalize-space()='Contact']")
    WebElement contactSection;
    
    @FindBy(xpath = "//input[@id='recipient-email']")
    WebElement contactEmail;
    
    @FindBy(xpath = "//input[@id='recipient-name']")
    WebElement contactName;
    
    @FindBy(xpath = "//textarea[@id='message-text']")
    WebElement entermessage;
    
    @FindBy(xpath = "//button[normalize-space()='Send message']")
    WebElement sendbtn;
    
    public void clickOnContactSection() {
        contactSection.click();
    }
    
    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(contactEmail));
        contactEmail.sendKeys(email);
    }
    
    public void enterName(String name) {
        contactName.sendKeys(name);
    }
    
    public void enterMessage(String message) {
        entermessage.sendKeys(message);
    }

    public void clickSendMessageButton() {
        sendbtn.click();
    }
   
}
