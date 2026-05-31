package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    WebDriver driver;

    By productsLink = By.xpath("//a[@href='/products']");
    By cartLink = By.xpath("//a[@href='/view_cart']");

    By subscriptionTitle = By.xpath("//div[@class='single-widget']/h2");
    By subscriptionEmail = By.id("susbscribe_email");
    By subscribeButton = By.id("subscribe");
    By successMessage = By.id("success-subscribe");

    By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    By viewCartFromModal = By.xpath("//u[text()='View Cart']");

    By quantityInput = By.id("quantity");
    By addToCartOnDetail = By.cssSelector("button.cart");
    By cartQuantityValue = By.xpath("//td[@class='cart_quantity']/button");

    By deleteButton = By.cssSelector("a.cart_quantity_delete");
    By emptyCartMessage = By.id("empty_cart");

    By searchInput = By.id("search_product");
    By searchButton = By.id("submit_search");
    By searchedProductsTitle = By.xpath("//h2[text()='Searched Products']");

    By cartProductNames = By.cssSelector("#cart_info_table .cart_description h4 a");
    
    public boolean isHomePageVisible() {
        return driver.getTitle().equals("Automation Exercise");
    }

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToProducts() {
        driver.findElement(productsLink).click();
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }

    public void scrollToFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public String getSubscriptionTitle() {
        return driver.findElement(subscriptionTitle).getText();
    }

    public void subscribe(String email) {
        driver.findElement(subscriptionEmail).sendKeys(email);
        driver.findElement(subscribeButton).click();
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return msg.getText();
    }

    public void addProductToCartById(int productId) {
        WebElement product = driver.findElement(By.xpath("//a[@data-product-id='" + productId + "']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", product);
    }

    public void clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickViewCart() {
        driver.findElement(viewCartFromModal).click();
    }

    public void clickViewProduct(int productId) {
        driver.findElement(By.xpath("//a[@href='/product_details/" + productId + "']")).click();
    }

    public void setQuantity(String quantity) {
        WebElement qty = driver.findElement(quantityInput);
        qty.clear();
        qty.sendKeys(quantity);
    }

    public void clickAddToCartOnDetailPage() {
        driver.findElement(addToCartOnDetail).click();
    }

    public String getCartQuantity() {
        return driver.findElement(cartQuantityValue).getText();
    }

    public void removeFirstProductFromCart() {
        driver.findElement(deleteButton).click();
    }

    public boolean isCartEmpty() {
        return driver.findElement(emptyCartMessage).isDisplayed();
    }

    public void searchProduct(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public String getSearchedProductsTitle() {
        return driver.findElement(searchedProductsTitle).getText();
    }

    public List<String> getCartProductNames() {
        List<WebElement> elements = driver.findElements(cartProductNames);
        List<String> names = new ArrayList<>();
        for (WebElement e : elements) {
            names.add(e.getText());
        }
        return names;
    }

    public int getCartItemsCount() {
        return driver.findElements(cartProductNames).size();
    }
}