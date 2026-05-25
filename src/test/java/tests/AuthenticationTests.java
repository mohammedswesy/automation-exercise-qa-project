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
}	