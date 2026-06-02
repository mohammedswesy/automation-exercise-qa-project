package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;

public class CartTests extends BaseTest {

    @Test
    public void verifySubscriptionInHomePage() {
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isHomePageVisible());
        cartPage.scrollToFooter();
        Assert.assertEquals(cartPage.getSubscriptionTitle().toUpperCase(), "SUBSCRIPTION");
        cartPage.subscribe("hamza.test@example.com");
        Assert.assertEquals(cartPage.getSuccessMessage(), "You have been successfully subscribed!");
    }

    @Test
    public void verifySubscriptionInCartPage() {
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isHomePageVisible());
        cartPage.goToCart();
        cartPage.scrollToFooter();
        Assert.assertEquals(cartPage.getSubscriptionTitle().toUpperCase(), "SUBSCRIPTION");
        cartPage.subscribe("hamza.test@example.com");
        Assert.assertEquals(cartPage.getSuccessMessage(), "You have been successfully subscribed!");
    }

    @Test
    public void addProductsInCart() {
        CartPage cartPage = new CartPage(driver);
        cartPage.goToProducts();
        cartPage.addProductToCartById(1);
        cartPage.clickContinueShopping();
        cartPage.addProductToCartById(2);
        cartPage.clickViewCart();
        Assert.assertEquals(cartPage.getCartItemsCount(), 2);
        Assert.assertTrue(cartPage.getCartProductNames().contains("Blue Top"));
        Assert.assertTrue(cartPage.getCartProductNames().contains("Men Tshirt"));
    }

    @Test
    public void verifyProductQuantityInCart() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickViewProduct(1);
        Assert.assertTrue(cartPage.isOnProductDetailPage());
        cartPage.setQuantity("4");
        cartPage.clickAddToCartOnDetailPage();
        cartPage.clickViewCart();
        Assert.assertEquals(cartPage.getCartQuantity(), "4");
    }

    @Test
    public void removeProductsFromCart() {
        CartPage cartPage = new CartPage(driver);
        cartPage.goToProducts();
        cartPage.addProductToCartById(1);
        cartPage.clickViewCart();
        Assert.assertEquals(cartPage.getCartItemsCount(), 1);
        cartPage.removeFirstProductFromCart();
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @Test
    public void searchProductsAndVerifyCartAfterLogin() {
        CartPage cartPage = new CartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        cartPage.goToProducts();
        cartPage.searchProduct("Blue Top");
        Assert.assertEquals(cartPage.getSearchedProductsTitle().toUpperCase(), "SEARCHED PRODUCTS");
        cartPage.addProductToCartById(1);
        cartPage.clickViewCart();
        Assert.assertTrue(cartPage.getCartProductNames().contains("Blue Top"));
        driver.get("https://automationexercise.com/login");
        loginPage.login("solefi8727@okcpress.com", "QualityAssurance");
        Assert.assertTrue(loginPage.getLoggedInText().contains("QA"));
        cartPage.goToCart();
        Assert.assertTrue(cartPage.getCartProductNames().contains("Blue Top"));
    }
}