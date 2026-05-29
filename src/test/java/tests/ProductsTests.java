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

}