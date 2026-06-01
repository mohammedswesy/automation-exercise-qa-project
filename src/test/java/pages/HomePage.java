package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By subscriptionText = By.xpath("//h2[contains(text(),'Subscription')]");

    By scrollUpArrow = By.id("scrollUp");

    By homePageSlider = By.id("slider");

    // Actions
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }

    public void clickScrollUpArrow() {
        wait.until(ExpectedConditions.elementToBeClickable(scrollUpArrow));
        driver.findElement(scrollUpArrow).click();
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // Validations
    public boolean isSubscriptionVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionText)).isDisplayed();
    }

    public boolean isHomePageTextVisible() {
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return longWait.until(driver -> {
            Number scrollY = (Number) ((JavascriptExecutor) driver)
                .executeScript("return window.scrollY;");
            return scrollY != null && scrollY.doubleValue() < 100;
        });
    }
}
