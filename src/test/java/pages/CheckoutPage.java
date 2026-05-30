package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class CheckoutPage {

				////////TC 22 — Add to cart from Recommended items
	
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
    
    
	////////TC 16 — Place Order: Login before Checkout
	/// 
 // Login
    By signupLoginBtn =
            By.linkText("Signup / Login");

    By loginEmail =
            By.xpath("//input[@data-qa='login-email']");

    By loginPassword =
            By.xpath("//input[@data-qa='login-password']");

    By loginButton =
            By.xpath("//button[@data-qa='login-button']");

    // Product
    By firstProductAddToCart =
            By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    // Cart
    By proceedToCheckoutBtn =
            By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    // Checkout
    By deliveryAddress =
            By.id("address_delivery");

    By billingAddress =
            By.id("address_invoice");

    // Payment
    By placeOrderBtn =
            By.xpath("//a[contains(text(),'Place Order')]");

    By nameOnCard =
            By.name("name_on_card");

    By cardNumber =
            By.name("card_number");

    By cvc =
            By.name("cvc");

    By expiryMonth =
            By.name("expiry_month");

    By expiryYear =
            By.name("expiry_year");

    By payAndConfirmBtn =
            By.id("submit");

    By orderPlacedMessage =
            By.xpath("//b[contains(text(),'Order Placed!')]");
    
    By downloadInvoiceBtn =
            By.xpath("//a[contains(text(),'Download Invoice')]");
    
    By subscriptionText =
            By.xpath("//h2[contains(text(),'Subscription')]");

    By scrollUpArrow =
            By.id("scrollUp");

    By fullFledgedText =
            By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]");
    
    
 // Login Actions

    public void clickSignupLogin() {
        driver.findElement(signupLoginBtn).click();
    }

    public void login(String email, String password) {

        driver.findElement(loginEmail).sendKeys(email);

        driver.findElement(loginPassword).sendKeys(password);

        driver.findElement(loginButton).click();
    }

    // Cart Actions

    public void addFirstProductToCart() {

        driver.findElement(firstProductAddToCart).click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartBtn));
    }

    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    // Validation

    public boolean isDeliveryAddressVisible() {
        return driver.findElement(deliveryAddress).isDisplayed();
    }

    public boolean isBillingAddressVisible() {
        return driver.findElement(billingAddress).isDisplayed();
    }

    // Payment

    public void clickPlaceOrder() {

        WebElement placeOrder =
                driver.findElement(placeOrderBtn);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", placeOrder);

        js.executeScript("arguments[0].click();", placeOrder);
    }

    public void enterPaymentDetails() {

        driver.findElement(nameOnCard).sendKeys("QA Tester");

        driver.findElement(cardNumber).sendKeys("1234123412341234");

        driver.findElement(cvc).sendKeys("123");

        driver.findElement(expiryMonth).sendKeys("12");

        driver.findElement(expiryYear).sendKeys("2030");
    }

    public void clickPayAndConfirm() {
        driver.findElement(payAndConfirmBtn).click();
    }

    public boolean isOrderPlacedVisible() {
        return driver.findElement(orderPlacedMessage).isDisplayed();
    }
   
    
    //////TC23 — Verify Address Details in Checkout Page 
    /// 
    /// 
    /// 
    
    /// TC24 — Download Invoice after purchase order
    public void clickDownloadInvoice() {

        WebElement downloadBtn =
                driver.findElement(downloadInvoiceBtn);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", downloadBtn);

        js.executeScript("arguments[0].click();", downloadBtn);
    }
    
    public boolean isSubscriptionVisible() {

        return driver.findElement(subscriptionText).isDisplayed();
    }

    
  ///  TC25 — Scroll Up using Arrow button
    public void clickScrollUpArrow() {

        driver.findElement(scrollUpArrow).click();
    }

    public boolean isHomePageTextVisible() {

        return driver.findElement(fullFledgedText).isDisplayed();
    }
    
   /// TC26 — Scroll Up without Arrow button
}