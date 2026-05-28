package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;

import static base.BaseTest.page;

public class FiltersTests extends BaseTest {
    ProductPage productsPage;

    @BeforeMethod
    public void navigateToProductsPage() {
        productsPage = new ProductPage(page);
        productsPage.navigateToProductsPage();
    }

    @Test
    public void categoryFilter(){
        page.locator("//button[normalize-space()='Bags & Luggage']").click();
        page.waitForTimeout(5000);
    }

    @Test
    public void priceFilter(){
        productsPage.setPriceRange(20,60);
        page.waitForLoadState();
        Assert.assertTrue(productsPage.areAllProductsOfSelectedPriceRange(20,60));

    }

    @Test
    public void sizeFilter(){
        productsPage.selectSize("S");
        page.waitForTimeout(15000);
        Assert.assertTrue(productsPage.hasProducts() || productsPage.isNoResultsDisplayed());
    }

    @Test
    public void colorFilter(){
        productsPage.selectSize("Red");
        page.waitForTimeout(15000);
        Assert.assertTrue(productsPage.hasProducts() || productsPage.isNoResultsDisplayed());
    }

    @Test
    public void specialFilter(){
        productsPage.selectSize("Featured");
        page.waitForTimeout(15000);
        Assert.assertTrue(productsPage.hasProducts() || productsPage.isNoResultsDisplayed());
    }





}