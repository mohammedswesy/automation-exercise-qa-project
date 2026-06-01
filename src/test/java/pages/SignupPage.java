package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {

    WebDriver driver;

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

    public void fillAccountInformation(String password, String day, String month, String year) {
        driver.findElement(passwordField).sendKeys(password);
        new Select(driver.findElement(daysDropdown)).selectByValue(day);
        new Select(driver.findElement(monthsDropdown)).selectByValue(month);
        new Select(driver.findElement(yearsDropdown)).selectByValue(year);
    }

    public void fillAddressDetails(String firstName, String lastName, String company, String address, String state, String city, String zipcode, String mobile) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileNumberField).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public String getAccountCreatedMessage() {
        return driver.findElement(accountCreatedHeading).getText();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}