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
		Assert.assertEquals(productsPage.verifyHomePageExist(), true, " Home page not displayed. ");
		Thread.sleep(200);
		
		//click on test case button
		productsPage.verifyTestCases();
		Thread.sleep(1000); // wait for safe side
		
		//see if the test case page is displayed or not
		Assert.assertEquals(productsPage.verifyTestCases(), true, " Test Cases page not displayed. ");
		
	}
	
											//TC008 Verify Products Page	
	@Test
	public void verifyAllProductsAndProductDetail () throws InterruptedException
	{
		ProductsPage productsPage = new ProductsPage(driver);
		
		//see if the home page is displayed or not
		Assert.assertEquals(productsPage.verifyHomePageExist(), true, " Home page not displayed. ");
		
		//click on products button
		productsPage.clickProductButton();
		Thread.sleep(100); // wait for safe side
		
		//see if the all products page is displayed or not
		Assert.assertEquals(productsPage.verifyAllProducts(), true, "  All products not displayed. ");
		
		//verify that products list are visible
		Assert.assertNotEquals(productsPage.verifyProductsList(), true, " Products list not displayed. ");
		Thread.sleep(100); // wait for safe side
		
		//view first product
		productsPage.viewFirstProduct();
		
		//verify that product details is opend
		Assert.assertEquals(productsPage.fProductDetailsPage(), true, " Product details not opened. ");
		
		// verify that all product details are visible
		Assert.assertEquals(productsPage.fProductName(), true, " Name not displayed. ");
		Assert.assertEquals(productsPage.fProductCata(), true, " Category not displayed. ");
		Assert.assertEquals(productsPage.fProductPrice(), true, " Price not displayed. ");
		Assert.assertEquals(productsPage.fProductAval(), true, " Availability not displayed. ");
		Assert.assertEquals(productsPage.fProductCondition(), true, " Condition not displayed. ");
		Assert.assertEquals(productsPage.fProductBrand(), true, " Brand not displayed. ");
		
	}
													//TC9: Search Product
	@Test
	public void searchProduct() throws InterruptedException 
	{
		ProductsPage productsPage = new ProductsPage(driver);
		
		//see if the home page is displayed or not
		Assert.assertEquals(productsPage.verifyHomePageExist(), true, " Home page not displayed. ");
		
		//click on products button
		productsPage.clickProductButton();
		Thread.sleep(100); // wait for safe side
		
		//see if the all products page is displayed or not
		Assert.assertEquals(productsPage.verifyAllProducts(), true, " ALL PRODUCTS page not displayed. ");
		Thread.sleep(400); // wait for safe side
		
		//make input in search bar
		productsPage.enterInputInSearch("Top");
		
		//see if the Searched Products is displayed or not
		Assert.assertEquals(productsPage.searchProductsHeadVis(), true, " Searched Products heading not displayed. ");
		
		//see if the Searched Products whom related to search displayed
		Assert.assertEquals(productsPage.sreachedItemRelated(), false, " Searched Products from search bar not displayed. ");
		
	}
	
												//TC18: View Catagory
	@Test
	public void viewCatagory()  {
		
		ProductsPage productsPage = new ProductsPage(driver);
		
		//see if the Catagory sidebar displayed
		Assert.assertEquals(productsPage.catagoryVisible(), true, " Catagory sidebar not displayed. ");
		
		//click on women catagory with subgcatogry Dress
		productsPage.womenCatagory();
		
		//see if the women Catagory header displayed
		Assert.assertEquals(productsPage.catagoryHearderDress(), true, " Catagory women header not displayed. ");
		
		//click on men catagory with subgcatogry Tshirt
				productsPage.menCatagory();
		
		//see if the women Catagory header displayed
		Assert.assertEquals(productsPage.catagoryHearderTshirts(), true, " Catagory men header not displayed. ");
		
	}
	
													//TC19:View & Cart Brand Products
	
	@Test
	public void viewAndCartBrandProduts() throws InterruptedException  {
		
		ProductsPage productsPage = new ProductsPage(driver);
		
		//click on products button
		productsPage.clickProductButton();
		Thread.sleep(100); // wait for safe side
		
		//verify Brands is visible on sidebar
		Assert.assertEquals(productsPage.brandSidebarVis(), true, " Brands is not visible on sidebar. ");
		
		//click on brand polo
		productsPage.brandPoloClick();
		
		//verify that user navigated to polo brands and products are displayed
		Assert.assertEquals(productsPage.brandPoloVis(), true, " Polo brands products are not displayed . ");
		Thread.sleep(1000); // wait for safe side
		
		//click on brand H&M
		productsPage.brandHMClick();
		
		//verify that user navigated to polo brands and products are displayed
		Assert.assertEquals(productsPage.brandHMVis(), true, " H&M brands products are not displayed . ");
		
		
	}
	
	
											//TC21: Add review on product
	@Test
	public void addReviewOnProduct() throws InterruptedException  {
		
		ProductsPage productsPage = new ProductsPage(driver);
		
		//click on products button
		productsPage.clickProductButton();
		Thread.sleep(400); // wait for safe side
		
		//see if the all products page is displayed or not
		Assert.assertEquals(productsPage.verifyAllProducts(), true, " ALL PRODUCTS page not displayed. ");
		Thread.sleep(400); // wait for safe side
		
		//view Blue Top product
		productsPage.viewFirstProduct();
		
		//verify that Write Your Review section is visible
		Assert.assertEquals(productsPage.reviewSectionVis(), true, "  Review sction is not displayed . ");
		
		//enter details of Review name, email, and message
		productsPage.enterReviewOnProduct("Reviewer", "reviewer@test.com", "Great product!");
		
		//verify that success message is visible
		Assert.assertEquals(productsPage.successMessage(), true, "  message review not send . ");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}