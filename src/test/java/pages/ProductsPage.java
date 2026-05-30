package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductsPage {

	WebDriver driver;
	 											//All locators needed
	
												//locators for TC007
	// home page locator
    By homePage = By.cssSelector("div[class='features_items'] h2[class='title text-center']");
    
    // test cases button locator
    By testCase = By.linkText("Test Cases");
    
    // to verify test case page is visable 
    By titleTestCases = By.xpath("//b[normalize-space()='Test Cases']");
    
    //variables 
    boolean hPageExist, testCaseVis ;
    
    /////////////////////////////////////////////////////////////////////////

    											//locators for TC008
    //locator for product button
    By productBtn = By.xpath("//a[@href='/products']");
    
    // to verify all products page is visable 
    By productsVisable = By.xpath("//div[@class='features_items']/h2");
    
    // to verify products list is visable 
    By productsList = By.xpath("//div[@class='features_items']//div[@class='col-sm-4']");
    
    // locator for first product
    By firstProduct = By.xpath("(//div[@class='features_items']//div[@class='choose']//a)[1]");
    
    //locator for product details of first product is opened (image)
    By fProductDetailsPage = By.cssSelector("div[class='view-product'] img[alt='ecommerce website products']");
    
    //locator for product details are visable
    By productName = By.xpath("//div[@class='product-information']/h2");
    By productCategory = By.xpath("//div[@class='product-details']//p[1]");
    By productPrice = By.xpath("//div[@class='product-information']//span//span");
    By productAvailability = By.xpath("//b[text()='Availability:']");
    By productCondition = By.xpath("//b[text()='Condition:']");
    By productBrand = By.xpath("//b[text()='Brand:']");
    
    //variables
    boolean allProductsVis, fProductDetailsOpen, name, category, price, availability, condition, brand;
	int productsListEmp;
    
    /////////////////////////////////////////////////////////////////////////
										//locators for TC009
    //locator for search bar
    By searchBar = By.xpath("//input[@id='search_product']");
    
    //locator for search bar
    By searchBtn = By.xpath("//button[@id='submit_search']");
    
    //locator for Searched Products header
    By searchedProductsHeader = By.xpath("//h2[normalize-space()='Searched Products']");
    
    //locator for all items related to word searched in search bar
    By searchedItems = By.xpath("//div[@class='single-products']//p");
    
    //variables
    boolean searchedProHeadVis, allSearchedProVis;
    //List<WebElement> productsRelated;
    
    //*********************************************************************************************************************\\
    
    //genral constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        
    }
    
	///////////////////////////////////////////////TC007 Verify Test Cases Page	
    
    // verify home page is visible
	public boolean verifyHomePageExist() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove();");
		js.executeScript("window.scrollBy(0, 300);");
		hPageExist = driver.findElement(homePage).isDisplayed();
    	return hPageExist;
    	
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
		testCaseVis= driver.findElement(titleTestCases).isDisplayed();
		return testCaseVis;
		
	}
	
//	public void verifyTestCasesPage() {
//		clickTestCase();
//		
//	}
	
	///////////////////////////////////////////////TC008 Verify All Products Page and product details	
	
	// click on product page
	public void clickProductButton() {
		driver.findElement(productBtn).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove();");
		driver.findElement(productBtn).click();
		
	}
	
	 // return if user is navigated to all produts page and displayed
		public boolean verifyAllProducts() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove();");
			allProductsVis= driver.findElement(productsVisable).isDisplayed();
			return allProductsVis;
			
		}
	
		// return that the product list is empty
		public int verifyProductsList() {
			List<WebElement> productsLists = driver.findElements(productsList);
			productsListEmp= productsLists.size();
			return productsListEmp;
			
		}
		
		//view first product details annd scroll for amount of pixels to pervent Ads
		public void viewFirstProduct() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove();");
			js.executeScript("window.scrollBy(0, 300);");
			driver.findElement(firstProduct).click();
			
		}
	
		//view first product is opened
		public boolean fProductDetailsPage() {
			fProductDetailsOpen= driver.findElement(fProductDetailsPage).isDisplayed();
			return fProductDetailsOpen;
			
		}
	
		//verify first product details are visible
		public boolean fProductName() {
			name= driver.findElement(productName).isDisplayed();
			return name;
					
		}
		
		public boolean fProductCata() {
			category= driver.findElement(productCategory).isDisplayed();
			return category;
					
		}
		
		public boolean fProductPrice() {
			price= driver.findElement(productPrice).isDisplayed();
			return price;
					
		}
		
		public boolean fProductAval() {
			availability= driver.findElement(productAvailability).isDisplayed();
			return availability;
					
		}
		
		public boolean fProductCondition() {
			condition= driver.findElement(productCondition).isDisplayed();
			return condition;
					
		}
		
		public boolean fProductBrand() {
			brand= driver.findElement(productBrand).isDisplayed();
			return brand;
					
		}
		
//		public void verifyAllProductsPageAndProductDetails() throws InterruptedException {
//			Thread.sleep(500);
////			verifyHomePageExist();
//			Thread.sleep(500);
//			clickProductButton();
//			Thread.sleep(100); // wait for safe side
////			verifyAllProducts();
//			verifyProductsList();
//			Thread.sleep(100); // wait for safe side
//			viewFirstProduct();
////			fProductDetailsPage();
////			fProductDetailsVis();
//			
//		}
	
	///////////////////////////////////////////////////////TC9: Search Product
	
		//enter product name in search bar "Top" and click
		public void enterInputInSearch(String item) {
			driver.findElement(searchBar).sendKeys(item);
			driver.findElement(searchBtn).click();
		}
		
		//verify Searched Products header is visible
		public boolean searchProductsHeadVis() {
			searchedProHeadVis= driver.findElement(searchedProductsHeader).isDisplayed();
			return searchedProHeadVis;
							
		}
		
		// return that the product list is empty
		public boolean sreachedItemRelated() {
			List<WebElement> productsRelated = driver.findElements(searchedItems);
			allSearchedProVis= productsRelated.isEmpty();
			return allSearchedProVis;
					
		}
		
	
	
}
	