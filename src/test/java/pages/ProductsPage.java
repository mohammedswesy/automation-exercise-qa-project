package pages;

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
	
    //genral constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    
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

    // verify user is navigated to test cases page
	public boolean verifyTestCases() {
		return driver.findElement(titleTestCases).isDisplayed();
	}
	
	
	
}
	