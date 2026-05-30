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

        checkoutPage.clickPlaceOrder();

        checkoutPage.enterPaymentDetails();

        checkoutPage.clickPayAndConfirm();

        Assert.assertTrue(checkoutPage.isOrderPlacedVisible());
    }
}