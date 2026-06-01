package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators — Recommended Items
    By recommendedProductAddBtn = By.xpath("(//a[contains(text(),'Add to cart')])[last()]");
    By viewCartBtn              = By.xpath("//u[text()='View Cart']");
    By cartProduct              = By.xpath("//td[@class='cart_description']");

    // Locators — Checkout
    By proceedToCheckoutBtn = By.xpath("//div[@class='col-sm-6']/a[contains(text(),'Proceed To Checkout')]");

    By deliveryAddress      = By.id("address_delivery");
    By billingAddress       = By.id("address_invoice");

    // Locators — Payment
    By placeOrderBtn    = By.xpath("//a[contains(text(),'Place Order')]");
    By nameOnCard       = By.name("name_on_card");
    By cardNumber       = By.name("card_number");
    By cvc              = By.name("cvc");
    By expiryMonth      = By.name("expiry_month");
    By expiryYear       = By.name("expiry_year");
    By payAndConfirmBtn = By.id("submit");
    By orderPlacedMsg   = By.xpath("//b[contains(text(),'Order Placed!')]");
    By downloadInvoiceBtn = By.xpath("//a[contains(text(),'Download Invoice')]");

    // Actions — Recommended Items
    public void addRecommendedProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(recommendedProductAddBtn));
        driver.findElement(recommendedProductAddBtn).click();
    }

    public void clickViewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));
        driver.findElement(viewCartBtn).click();
    }

    // Actions — Checkout
    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
        driver.findElement(proceedToCheckoutBtn).click();
    }

    public void clickPlaceOrder() {
        WebElement placeOrder = wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", placeOrder);
        js.executeScript("arguments[0].click();", placeOrder);
    }

    // Actions — Payment
    public void enterPaymentDetails(String name, String card, String cvcNum, String month, String year) {
        driver.findElement(nameOnCard).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(card);
        driver.findElement(cvc).sendKeys(cvcNum);
        driver.findElement(expiryMonth).sendKeys(month);
        driver.findElement(expiryYear).sendKeys(year);
    }

    public void clickPayAndConfirm() {
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(payAndConfirmBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btn);
        js.executeScript("arguments[0].click();", btn);
    }

    public void clickDownloadInvoice() {
        WebElement downloadBtn = wait.until(ExpectedConditions.elementToBeClickable(downloadInvoiceBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", downloadBtn);
        js.executeScript("arguments[0].click();", downloadBtn);
    }

    // Validations
    public boolean isProductDisplayedInCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartProduct)).isDisplayed();
    }

    public boolean isDeliveryAddressVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAddress)).isDisplayed();
    }

    public boolean isBillingAddressVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddress)).isDisplayed();
    }

    public boolean isOrderPlacedVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlacedMsg)).isDisplayed();
    }
}
