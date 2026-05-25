package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    WebDriver driver;

    By signupName = By.xpath("//input[@data-qa='signup-name']");
    By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");
    By existingEmailError = By.xpath("//p[text()='Email Address already exist!']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSignupName(String name) {
        driver.findElement(signupName).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        driver.findElement(signupEmail).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }

    public void signupWithExistingEmail(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        clickSignupButton();
    }

    public String getExistingEmailError() {
        return driver.findElement(existingEmailError).getText();
    }
}