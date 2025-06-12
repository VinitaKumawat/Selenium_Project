//package pageObject;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class Homepage {
//	
//		WebDriver driver ;
//		public Homepage(WebDriver driver){
//			this.driver = driver;
//			PageFactory.initElements(driver, this);
//		}
//		
//		    @FindBy(xpath = "//li[@class='nav-item active']//a[@class='nav-link']")
//		    WebElement homepageNavigationLink;
//		
//		    @FindBy(xpath = "//span[@class='carousel-control-next-icon']")
//		    WebElement homepageCursor;
//		    public void clickHomepageNavigationLink() {
//		        homepageNavigationLink.click();
//		    }
//		    public void clickHomepageCursor() {
//		        homepageCursor.click();
//		    }
//}

package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Homepage {

    private WebDriver driver;
    private WebDriverWait wait;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ------------------- Navigation Bar Elements -------------------
    
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeLink;

    @FindBy(xpath = "//a[contains(text(),'Contact')]")
    private WebElement contactLink;
 
    @FindBy(tagName = "title")
    WebElement pageTitle;
   

    // ------------------- Carousel Navigation -------------------

    @FindBy(xpath = "//span[@class='carousel-control-next-icon']")
    private WebElement carouselNextButton;

    @FindBy(xpath = "//span[@class='carousel-control-prev-icon']")
    private WebElement carouselPrevButton;

    // ------------------- Categories -------------------

    @FindBy(xpath = "//a[contains(text(),'Phones')]")
    private WebElement phonesCategory;

    @FindBy(xpath = "//a[contains(text(),'Laptops')]")
    private WebElement laptopsCategory;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    private WebElement monitorsCategory;

    // ------------------- Methods -------------------

    public void clickHome() {
        wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
    }

    public void clickContact() {
        wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickCarouselNext() {
        wait.until(ExpectedConditions.elementToBeClickable(carouselNextButton)).click();
    }

    public void clickCarouselPrev() {
        wait.until(ExpectedConditions.elementToBeClickable(carouselPrevButton)).click();
    }

    // ------------------- Category Methods -------------------

    public void selectPhonesCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(phonesCategory)).click();
    }

    public void selectLaptopsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(laptopsCategory)).click();
    }

    public void selectMonitorsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(monitorsCategory)).click();
    }
}

