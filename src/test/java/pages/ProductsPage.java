package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void jsClick(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    // ========================== LOCATORS ==========================

    By homePage = By.cssSelector("div[class='features_items'] h2[class='title text-center']");
    By testCase = By.linkText("Test Cases");
    By titleTestCases = By.xpath("//b[normalize-space()='Test Cases']");

    By productBtn = By.xpath("//a[@href='/products']");
    By productsVisable = By.xpath("//div[@class='features_items']/h2");
    By productsList = By.xpath("//div[@class='features_items']//div[@class='col-sm-4']");
    By firstProduct = By.xpath("(//div[@class='features_items']//div[@class='choose']//a)[1]");

    By fProductDetailsPage = By.cssSelector("div[class='view-product'] img[alt='ecommerce website products']");

    By productName = By.xpath("//div[@class='product-information']/h2");
    By productCategory = By.xpath("//div[@class='product-details']//p[1]");
    By productPrice = By.xpath("//div[@class='product-information']//span//span");
    By productAvailability = By.xpath("//b[text()='Availability:']");
    By productCondition = By.xpath("//b[text()='Condition:']");
    By productBrand = By.xpath("//b[text()='Brand:']");

    By searchBar = By.xpath("//input[@id='search_product']");
    By searchBtn = By.xpath("//button[@id='submit_search']");
    By searchedProductsHeader = By.xpath("//h2[normalize-space()='Searched Products']");
    By searchedItems = By.xpath("//div[@class='single-products']//p");

    By catagoryHeadVis = By.xpath("//h2[normalize-space()='Category']");
    By womenCatagory = By.xpath("//a[normalize-space()='Women']");
    By subCatagoryWomen = By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]");
    By catagoryHeaderWomenDisplayed = By.xpath("//h2[normalize-space()='Women - Dress Products']");

    By menCatagory = By.xpath("//a[normalize-space()='Men']");
    By subCatagoryMen = By.xpath("//a[normalize-space()='Tshirts']");
    By catagoryHeaderMenDisplayed = By.xpath("//h2[normalize-space()='Men - Tshirts Products']");

    By brandSideBar = By.xpath("//h2[normalize-space()='Brands']");
    By brandPolo = By.xpath("//a[@href='/brand_products/Polo']");
    By brandPoloPageVis = By.xpath("//h2[normalize-space()='Brand - Polo Products']");

    By brandHM = By.xpath("//a[@href='/brand_products/H&M']");
    By brandHMPageVis = By.xpath("//h2[normalize-space()='Brand - H&M Products']");

    By reviweSectionVis = By.xpath("//a[normalize-space()='Write Your Review']");
    By reviwerName = By.xpath("//input[@id='name']");
    By reviwerEmail = By.xpath("//input[@id='email']");
    By reviweMessage = By.xpath("//textarea[@id='review']");
    By submitBtn = By.xpath("//button[@id='button-review']");
    By successMessage = By.xpath("//span[normalize-space()='Thank you for your review.']");

    // ========================== TC007 ==========================

    public boolean verifyHomePageExist() {
        return driver.findElement(homePage).isDisplayed();
    }

    public void clickTestCase() {
        jsClick(testCase);
    }

    public boolean verifyTestCases() {
        return driver.findElement(titleTestCases).isDisplayed();
    }

    // ========================== TC008 ==========================

    public void clickProductButton() {
        jsClick(productBtn);
    }

    public boolean verifyAllProducts() {
        return driver.findElement(productsVisable).isDisplayed();
    }

    public int verifyProductsList() {
        List<WebElement> productsLists = driver.findElements(productsList);
        return productsLists.size();
    }

    public void viewFirstProduct() {

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,300)");

        jsClick(firstProduct);
    }

    public boolean fProductDetailsPage() {
        return driver.findElement(fProductDetailsPage).isDisplayed();
    }

    public boolean fProductName() {
        return driver.findElement(productName).isDisplayed();
    }

    public boolean fProductCata() {
        return driver.findElement(productCategory).isDisplayed();
    }

    public boolean fProductPrice() {
        return driver.findElement(productPrice).isDisplayed();
    }

    public boolean fProductAval() {
        return driver.findElement(productAvailability).isDisplayed();
    }

    public boolean fProductCondition() {
        return driver.findElement(productCondition).isDisplayed();
    }

    public boolean fProductBrand() {
        return driver.findElement(productBrand).isDisplayed();
    }

    // ========================== TC009 ==========================

    public void enterInputInSearch(String item) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar))
                .sendKeys(item);

        jsClick(searchBtn);
    }

    public boolean searchProductsHeadVis() {
        return driver.findElement(searchedProductsHeader).isDisplayed();
    }

    public boolean sreachedItemRelated() {
        List<WebElement> productsRelated = driver.findElements(searchedItems);
        return !productsRelated.isEmpty();
    }

    // ========================== TC018 ==========================

    public boolean catagoryVisible() {
        return driver.findElement(catagoryHeadVis).isDisplayed();
    }

    public void clcickOnWomenCata() {
        jsClick(womenCatagory);
    }

    public void clcickOnWomSubCata() {
        jsClick(subCatagoryWomen);
    }

    public boolean catagoryHearderDress() {
        return driver.findElement(catagoryHeaderWomenDisplayed).isDisplayed();
    }

    public void clcickOnMenCata() {
        jsClick(menCatagory);
    }

    public void clcickOnMenSubCata() {
        jsClick(subCatagoryMen);
    }

    public boolean catagoryHearderTshirts() {
        return driver.findElement(catagoryHeaderMenDisplayed).isDisplayed();
    }

    public void womenCatagory() {
        clcickOnWomenCata();
        clcickOnWomSubCata();
    }

    public void menCatagory() {
        clcickOnMenCata();
        clcickOnMenSubCata();
    }

    // ========================== TC019 ==========================

    public boolean brandSidebarVis() {
        return driver.findElement(brandSideBar).isDisplayed();
    }

    public void brandPoloClick() {
        jsClick(brandPolo);
    }

    public boolean brandPoloVis() {
        return driver.findElement(brandPoloPageVis).isDisplayed();
    }

    public void brandHMClick() {
        jsClick(brandHM);
    }

    public boolean brandHMVis() {
        return driver.findElement(brandHMPageVis).isDisplayed();
    }

    // ========================== TC021 ==========================

    public boolean reviewSectionVis() {
        return driver.findElement(reviweSectionVis).isDisplayed();
    }

    public void enterName(String name) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(reviwerName))
                .sendKeys(name);
    }

    public void enterEmail(String email) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(reviwerEmail))
                .sendKeys(email);
    }

    public void enterReviewMess(String reviewerMessage) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(reviweMessage))
                .sendKeys(reviewerMessage);
    }

    public void clickSubmit() {
        jsClick(submitBtn);
    }

    public void enterReviewOnProduct(String name, String email, String reviewerMessage) {

        enterName(name);
        enterEmail(email);
        enterReviewMess(reviewerMessage);
        clickSubmit();
    }

    public boolean successMessage() {
        return driver.findElement(successMessage).isDisplayed();
    }
}