package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

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

    By searchInput = By.id("search_product");
    By searchButton = By.id("submit_search");
    By searchedProductsTitle = By.xpath("//h2[text()='Searched Products']");

    By cartInfoTable = By.id("cart_info_table");
    By cartProductNames = By.cssSelector("#cart_info_table .cart_description h4 a");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void jsClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isHomePageVisible() {
        return driver.getTitle().equals("Automation Exercise");
    }

    public boolean isOnProductDetailPage() {
        return driver.getCurrentUrl().contains("product_details");
    }

    public void goToProducts() {
        jsClick(productsLink);
    }

    public void goToCart() {
        jsClick(cartLink);
    }

    public void scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public String getSubscriptionTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionTitle)).getText();
    }

    public void subscribe(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionEmail)).sendKeys(email);
        jsClick(subscribeButton);
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    public void addProductToCartById(int productId) {
        By addButton = By.xpath("//a[@data-product-id='" + productId + "']");
        jsClick(addButton);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartFromModal));
        } catch (TimeoutException e) {
            jsClick(addButton);
            wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartFromModal));
        }
    }

    public void clickContinueShopping() {
        jsClick(continueShoppingButton);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(viewCartFromModal));
    }

    public void clickViewCart() {
        jsClick(viewCartFromModal);
    }

    public void clickViewProduct(int productId) {
        jsClick(By.xpath("//a[@href='/product_details/" + productId + "']"));
    }

    public void setQuantity(String quantity) {
        WebElement qty = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput));
        qty.clear();
        qty.sendKeys(quantity);
    }

    public void clickAddToCartOnDetailPage() {
        jsClick(addToCartOnDetail);
    }

    public String getCartQuantity() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartQuantityValue)).getText();
    }

    public void removeFirstProductFromCart() {
        jsClick(deleteButton);
    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.numberOfElementsToBe(cartProductNames, 0)).isEmpty();
    }

    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(productName);
        jsClick(searchButton);
    }

    public String getSearchedProductsTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsTitle)).getText();
    }

    public List<String> getCartProductNames() {
        wait.until(ExpectedConditions.presenceOfElementLocated(cartInfoTable));
        List<WebElement> elements = driver.findElements(cartProductNames);
        List<String> names = new ArrayList<>();
        for (WebElement e : elements) {
            names.add(e.getText());
        }
        return names;
    }

    public int getCartItemsCount() {
        wait.until(ExpectedConditions.presenceOfElementLocated(cartInfoTable));
        return driver.findElements(cartProductNames).size();
    }
}