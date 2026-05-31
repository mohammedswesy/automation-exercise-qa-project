package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

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
}