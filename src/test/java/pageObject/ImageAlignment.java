package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ImageAlignment {
    WebDriver driver;

    private By productImages = By.cssSelector(".card-img-top img-fluid");

    public ImageAlignment(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getProductImages() {
        return driver.findElements(productImages);
    }

    public boolean verifyImageAlignment() {
        List<WebElement> images = getProductImages();
        int expectedXPosition = -1;

        for (WebElement image : images) {
            int currentXPosition = image.getLocation().getX();

            if (expectedXPosition == -1) {
                expectedXPosition = currentXPosition;
            }

            if (currentXPosition != expectedXPosition) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyImageSizes() {
        List<WebElement> images = getProductImages();
        int expectedWidth = -1;
        int expectedHeight = -1;

        for (WebElement image : images) {
            int width = image.getSize().getWidth();
            int height = image.getSize().getHeight();

            if (expectedWidth == -1 && expectedHeight == -1) {
                expectedWidth = width;
                expectedHeight = height;
            }

            if (width != expectedWidth || height != expectedHeight) {
                return false;
            }
        }
        return true;
    }
}