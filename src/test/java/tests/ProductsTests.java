package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductsPage;

public class ProductsTests extends BaseTest {
	
											//TC007 Verify Test Cases Page
	@Test
	public void testCasePage() throws InterruptedException {
		ProductsPage productsPage = new ProductsPage(driver);
		
		//see if the home page is displayed or not
		Assert.assertEquals(productsPage.homePageExist(), true);
		Thread.sleep(200);
		
		//click on test case button
		productsPage.clickTestCase();
		Thread.sleep(1000); // wait for safe side
		
		//see if the test case page is displayed or not
		Assert.assertEquals(productsPage.verifyTestCases(), true);
		
	}
	
											//TC008 Verify Products Page	
	@Test
	public void verifyAllProductsAndProductDetail () throws InterruptedException 
	{
		ProductsPage productsPage = new ProductsPage(driver);
		
		//see if the home page is displayed or not
		Assert.assertEquals(productsPage.homePageExist(), true);
		
		//click on products button
		productsPage.clickProductButton();
		Thread.sleep(100); // wait for safe side
		
		//see if the all products page is displayed or not
		Assert.assertEquals(productsPage.verifyAllProducts(), true);
		
		//verify that products list are visible
		Assert.assertNotEquals(productsPage.verifyProductsList(), true);
		Thread.sleep(100); // wait for safe side
		
		//view first product
		productsPage.viewFirstProduct();
		
		//verify that product details is opend
		Assert.assertEquals(productsPage.fProductDetailsPage(), true);
		
		// verify that all product details are visible
		Assert.assertEquals(productsPage.fProductDetailsVis(), true);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}