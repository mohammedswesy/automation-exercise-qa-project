package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {

    WebDriver driver;
    WebDriverWait wait;

    By signupName = By.xpath("//input[@data-qa='signup-name']");
    By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");
    By existingEmailError = By.xpath("//p[text()='Email Address already exist!']");

    By passwordField = By.id("password");
    By daysDropdown = By.id("days");
    By monthsDropdown = By.id("months");
    By yearsDropdown = By.id("years");

    By firstNameField = By.id("first_name");
    By lastNameField = By.id("last_name");
    By companyField = By.id("company");
    By addressField = By.id("address1");
    By stateField = By.id("state");
    By cityField = By.id("city");
    By zipcodeField = By.id("zipcode");
    By mobileNumberField = By.id("mobile_number");

    By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    By accountCreatedHeading = By.xpath("//h2[@data-qa='account-created']/b");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public SignupPage(WebDriver driver) {
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

    public void enterSignupName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupName)).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupEmail)).sendKeys(email);
    }

    public void clickSignupButton() {
        jsClick(signupButton);
    }

    public void signupWithExistingEmail(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        clickSignupButton();
    }

    public String getExistingEmailError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(existingEmailError)).getText();
    }

    public void fillAccountInformation(String password, String day, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(daysDropdown))).selectByValue(day);
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(monthsDropdown))).selectByValue(month);
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(yearsDropdown))).selectByValue(year);
    }

    public void fillAddressDetails(String firstName, String lastName, String company,
                                   String address, String state, String city,
                                   String zipcode, String mobile) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyField)).sendKeys(company);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressField)).sendKeys(address);
        wait.until(ExpectedConditions.visibilityOfElementLocated(stateField)).sendKeys(state);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipcodeField)).sendKeys(zipcode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberField)).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        jsClick(createAccountButton);
    }

    public String getAccountCreatedMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedHeading)).getText();
    }

    public void clickContinue() {
        jsClick(continueButton);
    }
}