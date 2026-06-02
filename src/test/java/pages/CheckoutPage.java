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

    By recommendedProductAddBtn = By.xpath("(//a[contains(text(),'Add to cart')])[last()]");
    By viewCartBtn = By.xpath("//u[text()='View Cart']");
    By cartProduct = By.xpath("//td[@class='cart_description']");

    By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    By deliveryAddress = By.id("address_delivery");
    By billingAddress = By.id("address_invoice");

    By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");
    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");
    By payAndConfirmBtn = By.id("submit");
    By orderPlacedMsg = By.xpath("//b[contains(text(),'Order Placed!')]");
    By downloadInvoiceBtn = By.xpath("//a[contains(text(),'Download Invoice')]");

    private void jsClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public void addRecommendedProductToCart() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");

        jsClick(recommendedProductAddBtn);
    }

    public void clickViewCart() {
        jsClick(viewCartBtn);
    }

    public void clickProceedToCheckout() {
        jsClick(proceedToCheckoutBtn);
    }

    public void clickPlaceOrder() {
        jsClick(placeOrderBtn);
    }

    public void enterPaymentDetails(String name, String card, String cvcNum, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCard)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber)).sendKeys(card);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvc)).sendKeys(cvcNum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(expiryMonth)).sendKeys(month);
        wait.until(ExpectedConditions.visibilityOfElementLocated(expiryYear)).sendKeys(year);
    }

    public void clickPayAndConfirm() {
        jsClick(payAndConfirmBtn);
    }

    public void clickDownloadInvoice() {
        jsClick(downloadInvoiceBtn);
    }

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