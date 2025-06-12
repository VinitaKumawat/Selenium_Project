package pageObject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class Product {
    WebDriver driver;

    public Product(WebDriver driver) {
        this.driver = driver; 
        PageFactory.initElements(driver, this);
    }

    private By productLink = By.xpath("//a[text()='Samsung galaxy s6']");
    private By addToCartButton = By.xpath("//a[normalize-space()='Add to cart']");
    
    public void clickOnProduct() {
		  driver.findElement(productLink).click();
		
	}

	public void clickAddToCart1() {
		// TODO Auto-generated method stub
		driver.findElement(addToCartButton).click();
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