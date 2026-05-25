package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTests extends BaseTest {

    @Test
    public void loginWithValidCredentials() {

        driver.findElement(By.linkText("Signup / Login")).click();

        driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                .sendKeys("solefi8727@okcpress.com");

        driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                .sendKeys("QualityAssurance");

        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        String loggedInText = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"))
                .getText();

        Assert.assertTrue(loggedInText.contains("QA"));
    }

    @Test
    public void logoutUser() {

        driver.findElement(By.linkText("Signup / Login")).click();

        driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                .sendKeys("solefi8727@okcpress.com");

        driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                .sendKeys("QualityAssurance");

        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        driver.findElement(By.linkText("Logout")).click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("login"));
    }
    
    @Test
    public void loginWithInvalidCredentials() {

        driver.findElement(By.linkText("Signup / Login")).click();

        driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                .sendKeys("wrong@test.com");

        driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                .sendKeys("wrongpassword");

        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        String errorMessage = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"))
                .getText();

        Assert.assertEquals(errorMessage, "Your email or password is incorrect!");
    }
    
    @Test
    public void registerWithExistingEmail() {

        driver.findElement(By.linkText("Signup / Login")).click();

        driver.findElement(By.xpath("//input[@data-qa='signup-name']"))
                .sendKeys("QA");

        driver.findElement(By.xpath("//input[@data-qa='signup-email']"))
                .sendKeys("solefi8727@okcpress.com");

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        String errorMessage = driver.findElement(By.xpath("//p[text()='Email Address already exist!']"))
                .getText();

        Assert.assertEquals(errorMessage, "Email Address already exist!");
    }
}