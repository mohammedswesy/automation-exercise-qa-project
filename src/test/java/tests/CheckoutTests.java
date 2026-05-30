package tests;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTests extends BaseTest {

    @Test
    public void addToCartFromRecommendedItems() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        checkoutPage.addRecommendedProductToCart();

        checkoutPage.clickViewCart();

        Assert.assertTrue(checkoutPage.isProductDisplayedInCart());
    }
    
////////TC 16 — Place Order: Login before Checkout
    @Test
    public void placeOrderLoginBeforeCheckout() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.clickSignupLogin();

        checkoutPage.login("solefi8727@okcpress.com", "QualityAssurance");

        checkoutPage.addFirstProductToCart();

        checkoutPage.clickViewCart();

        checkoutPage.clickProceedToCheckout();

        Assert.assertTrue(checkoutPage.isDeliveryAddressVisible());

        Assert.assertTrue(checkoutPage.isBillingAddressVisible());

        System.out.println("Delivery Address is displayed");

        System.out.println("Billing Address is displayed");
        
        checkoutPage.clickPlaceOrder();

        checkoutPage.enterPaymentDetails();

        checkoutPage.clickPayAndConfirm();

        Assert.assertTrue(checkoutPage.isOrderPlacedVisible());
    }
    
    //////TC23 — Verify Address Details in Checkout Page 
    @Test
    public void verifyAddressDetailsInCheckoutPage() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.clickSignupLogin();

        checkoutPage.login("solefi8727@okcpress.com", "QualityAssurance");

        checkoutPage.addFirstProductToCart();

        checkoutPage.clickViewCart();

        checkoutPage.clickProceedToCheckout();

        Assert.assertTrue(checkoutPage.isDeliveryAddressVisible());

        Assert.assertTrue(checkoutPage.isBillingAddressVisible());
    }
    
    //////TC24 — Download Invoice after purchase order
    /// 
    @Test
    public void downloadInvoiceAfterPurchaseOrder() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.clickSignupLogin();

        checkoutPage.login("solefi8727@okcpress.com", "QualityAssurance");

        checkoutPage.addFirstProductToCart();

        checkoutPage.clickViewCart();

        checkoutPage.clickProceedToCheckout();

        checkoutPage.clickPlaceOrder();

        checkoutPage.enterPaymentDetails();

        checkoutPage.clickPayAndConfirm();

        Assert.assertTrue(checkoutPage.isOrderPlacedVisible());

        checkoutPage.clickDownloadInvoice();
    }
    
    
    
  ///  TC25 — Scroll Up using Arrow button
  /// 
    @Test
    public void verifyScrollUpUsingArrowButton()throws InterruptedException {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Thread.sleep(2000);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Assert.assertTrue(checkoutPage.isSubscriptionVisible());

        checkoutPage.clickScrollUpArrow();

        Assert.assertTrue(checkoutPage.isHomePageTextVisible());
    }
    
   
    /// TC26 — Scroll Up without Arrow button
    /// 
    @Test
    public void verifyScrollUpWithoutArrowButton() throws InterruptedException {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Thread.sleep(2000);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Assert.assertTrue(checkoutPage.isSubscriptionVisible());

        js.executeScript("window.scrollTo(0, 0)");

        Assert.assertTrue(checkoutPage.isHomePageTextVisible());
    }
}
