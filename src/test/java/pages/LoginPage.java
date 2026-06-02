package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By signupLoginLink = By.linkText("Signup / Login");
    By loginEmail = By.xpath("//input[@data-qa='login-email']");
    By loginPassword = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    By loginErrorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");
    By logoutLink = By.linkText("Logout");

    By deleteAccountLink = By.linkText("Delete Account");
    By accountDeletedHeading = By.xpath("//h2[@data-qa='account-deleted']/b");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void jsClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public void openLoginPage() {
        jsClick(signupLoginLink);
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPassword)).sendKeys(password);
        jsClick(loginButton);
    }

    public String getLoggedInText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInText)).getText();
    }

    public String getLoginErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage)).getText();
    }

    public void logout() {
        jsClick(logoutLink);
    }

    public void clickDeleteAccount() {
        jsClick(deleteAccountLink);
    }

    public String getAccountDeletedMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedHeading)).getText();
    }

    public void clickContinue() {
        jsClick(continueButton);
    }
}