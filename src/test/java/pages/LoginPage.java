package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    By signupLoginLink = By.linkText("Signup / Login");
    By loginEmail = By.xpath("//input[@data-qa='login-email']");
    By loginPassword = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    By loginErrorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");
    By logoutLink = By.linkText("Logout");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.findElement(signupLoginLink).click();
    }

    public void login(String email, String password) {
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
        WebElement loginBtn = driver.findElement(loginButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
    }

    public String getLoggedInText() {
        return driver.findElement(loggedInText).getText();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(loginErrorMessage).getText();
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }
}