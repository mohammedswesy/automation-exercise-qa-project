package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestData;

public class CheckoutTests extends BaseTest {

    // TC 22 — Add to cart from Recommended items
    @Test
    public void addToCartFromRecommendedItems() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.scrollToBottom();

        checkoutPage.addRecommendedProductToCart();

        checkoutPage.clickViewCart();

        Assert.assertTrue(checkoutPage.isProductDisplayedInCart());
    }

    // TC 16 — Place Order: Login before Checkout
    @Test
    public void placeOrderLoginBeforeCheckout() {

        LoginPage loginPage = new LoginPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HomePage homePage = new HomePage(driver);

        driver.get("https://automationexercise.com/login");

        loginPage.login(TestData.LOGIN_EMAIL, TestData.LOGIN_PASSWORD);

        homePage.scrollToBottom();

        checkoutPage.addRecommendedProductToCart();
        checkoutPage.clickViewCart();
        checkoutPage.clickProceedToCheckout();

        Assert.assertTrue(checkoutPage.isDeliveryAddressVisible());
        Assert.assertTrue(checkoutPage.isBillingAddressVisible());

        checkoutPage.clickPlaceOrder();
        checkoutPage.enterPaymentDetails(
                TestData.CARD_NAME,
                TestData.CARD_NUMBER,
                TestData.CARD_CVC,
                TestData.CARD_EXPIRY_MONTH,
                TestData.CARD_EXPIRY_YEAR
        );
        checkoutPage.clickPayAndConfirm();

        Assert.assertTrue(checkoutPage.isOrderPlacedVisible());
    }

    // TC 23 — Verify Address Details in Checkout Page
    @Test
    public void verifyAddressDetailsInCheckoutPage() {

        LoginPage loginPage = new LoginPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HomePage homePage = new HomePage(driver);

        driver.get("https://automationexercise.com/login");

        loginPage.login(TestData.LOGIN_EMAIL, TestData.LOGIN_PASSWORD);

        homePage.scrollToBottom();

        checkoutPage.addRecommendedProductToCart();
        checkoutPage.clickViewCart();
        checkoutPage.clickProceedToCheckout();

        Assert.assertTrue(checkoutPage.isDeliveryAddressVisible());
        Assert.assertTrue(checkoutPage.isBillingAddressVisible());
    }

    // TC 24 — Download Invoice after purchase order
    @Test
    public void downloadInvoiceAfterPurchaseOrder() {

        LoginPage loginPage = new LoginPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HomePage homePage = new HomePage(driver);

        driver.get("https://automationexercise.com/login");

        loginPage.login(TestData.LOGIN_EMAIL, TestData.LOGIN_PASSWORD);

        homePage.scrollToBottom();

        checkoutPage.addRecommendedProductToCart();
        checkoutPage.clickViewCart();
        checkoutPage.clickProceedToCheckout();
        checkoutPage.clickPlaceOrder();

        checkoutPage.enterPaymentDetails(
                TestData.CARD_NAME,
                TestData.CARD_NUMBER,
                TestData.CARD_CVC,
                TestData.CARD_EXPIRY_MONTH,
                TestData.CARD_EXPIRY_YEAR
        );

        checkoutPage.clickPayAndConfirm();

        Assert.assertTrue(checkoutPage.isOrderPlacedVisible());

        checkoutPage.clickDownloadInvoice();
    }

    // TC 25 — Scroll Up using Arrow button
    @Test
    public void verifyScrollUpUsingArrowButton() {

        HomePage homePage = new HomePage(driver);

        homePage.scrollToBottom();

        Assert.assertTrue(homePage.isSubscriptionVisible());

        homePage.clickScrollUpArrow();

        Assert.assertTrue(homePage.isHomePageTextVisible());
    }

    // TC 26 — Scroll Up without Arrow button
    @Test
    public void verifyScrollUpWithoutArrowButton() {

        HomePage homePage = new HomePage(driver);

        homePage.scrollToBottom();

        Assert.assertTrue(homePage.isSubscriptionVisible());

        homePage.scrollToTop();

        Assert.assertTrue(homePage.isHomePageTextVisible());
    }
    
 // TC 14 — Place Order: Register while Checkout
    @Test
    public void placeOrderRegisterWhileCheckout() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.scrollToBottom();

        checkoutPage.addRecommendedProductToCart();

        checkoutPage.clickViewCart();

        Assert.assertTrue(checkoutPage.isProductDisplayedInCart());
    }
    
 // TC 15 — Place Order: Register before Checkout

    @Test
    public void placeOrderRegisterBeforeCheckout() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.scrollToBottom();

        checkoutPage.addRecommendedProductToCart();

        checkoutPage.clickViewCart();

        Assert.assertTrue(checkoutPage.isProductDisplayedInCart());
    }
}