package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignupPage;

public class AuthenticationTests extends BaseTest {

    @Test
    public void loginWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        loginPage.login("solefi8727@okcpress.com", "QualityAssurance");

        Assert.assertTrue(loginPage.getLoggedInText().contains("QA"));
    }

    @Test
    public void logoutUser() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        loginPage.login("solefi8727@okcpress.com", "QualityAssurance");
        loginPage.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void loginWithInvalidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        loginPage.login("wrong@test.com", "wrongpassword");

        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                "Your email or password is incorrect!"
        );
    }
    
    @Test
    public void registerWithExistingEmail() {

        LoginPage loginPage = new LoginPage(driver);
        SignupPage signupPage = new SignupPage(driver);

        loginPage.openLoginPage();

        signupPage.signupWithExistingEmail("QA", "solefi8727@okcpress.com");

        Assert.assertEquals(
                signupPage.getExistingEmailError(),
                "Email Address already exist!"
        );
        
    }

    @Test
    public void registerNewUser() {
        LoginPage loginPage = new LoginPage(driver);
        SignupPage signupPage = new SignupPage(driver);

        loginPage.openLoginPage();

        String uniqueEmail = "testuser_" + System.currentTimeMillis() + "@gmail.com";

        signupPage.signupWithExistingEmail("Test User", uniqueEmail); 

        signupPage.fillAccountInformation("QualityAssurance", "1", "1", "1990");

        signupPage.fillAddressDetails("Test", "User", "Automation Co.", "123 Test St", "California", "Los Angeles", "90001", "1234567890");
        
        signupPage.clickCreateAccount();

        Assert.assertEquals(signupPage.getAccountCreatedMessage(), "ACCOUNT CREATED!");
        signupPage.clickContinue();

        Assert.assertTrue(loginPage.getLoggedInText().contains("Test User"));

        loginPage.clickDeleteAccount();

        Assert.assertEquals(loginPage.getAccountDeletedMessage(), "ACCOUNT DELETED!");
        loginPage.clickContinue();
    }
}