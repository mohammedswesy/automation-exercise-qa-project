package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductsPage {

	WebDriver driver;
	 
	// home page locator
    By homePage = By.xpath("//h2[normalize-space()='Features Items']");
    // test cases button locator
    By testCase = By.linkText("Test Cases");
    // to verify test case page is visable 
    By titleTestCases = By.xpath("//b[normalize-space()='Test Cases']");
    /////////////////////////////////////////////////////////////////////////
    //locator for product button
    By productBtn = By.xpath("//a[@href='/products']");
    // to verify products page is visable 
    By productsVisable = By.xpath("//h2[normalize-space()='All Products']");
    // to verify products list is visable 
    By productsList = By.xpath("//h2[normalize-space()='All Products']");
    // locator for first product
    By firstProduct = By.xpath("(//div[@class='features_items']//div[@class='choose']//a)[1]");
    //locator for product details of first product is opened (image)
    By fProductDetailsPage = By.cssSelector("div[class='view-product'] img[alt='ecommerce website products']");
  //locator for product details of first product is opened
    By pDetailsVisable = By.cssSelector(".product-information");
    
    //genral constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        
    }
    
	///////////////////////////////////////////////TC007 Verify Test Cases Page	
    
    // verify home page is visible
	public boolean homePageExist() {
    	return driver.findElement(homePage).isDisplayed();
    	
	}
    
	// click test cases button and prevent ad pop up
	public void clickTestCase() {
		 WebElement testCaseSection = driver.findElement(testCase);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 testCaseSection.click();
		 js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove();");
		 testCaseSection.click();
		 
	}

    // return if user is navigated to test cases page and displayed
	public boolean verifyTestCases() {
		return driver.findElement(titleTestCases).isDisplayed();
		
	}
	
	///////////////////////////////////////////////TC008 Verify Products Page	
	
	// click on product page
	public void clickProductButton() {
		driver.findElement(productBtn).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove();");
		driver.findElement(productBtn).click();
		
	}
	
	 // return if user is navigated to all produts page and displayed
		public boolean verifyAllProducts() {
			return driver.findElement(productsVisable).isDisplayed();
			
		}
	
		// return that the product list is empty
		public boolean verifyProductsList() {
			List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='features_items']//div[@class='col-sm-4']"));
			return productsList.isEmpty();
			
		}
		
		//view first product details 
		public void viewFirstProduct() {
			driver.findElement(firstProduct).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove();");
			
		}
	
		//view first product is opened
		public boolean fProductDetailsPage() {
			return driver.findElement(fProductDetailsPage).isDisplayed();
			
		}
	
		//verify first product details are visible
		public boolean fProductDetailsVis() {
			return driver.findElement(pDetailsVisable).isDisplayed();
					
			}
	
	
	
	
	
}
	