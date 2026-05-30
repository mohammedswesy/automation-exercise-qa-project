package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Recommended Item
    By recommendedProductAddBtn =
            By.xpath("(//a[contains(text(),'Add to cart')])[last()]");

    By viewCartBtn =
            By.xpath("//u[text()='View Cart']");

    By cartProduct =
            By.xpath("//td[@class='cart_description']");

    // Actions

    public void addRecommendedProductToCart() {
        driver.findElement(recommendedProductAddBtn).click();
    }

    public void clickViewCart() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));

        driver.findElement(viewCartBtn).click();
    }

    // Validation

    public boolean isProductDisplayedInCart() {
        return driver.findElement(cartProduct).isDisplayed();
    }
}