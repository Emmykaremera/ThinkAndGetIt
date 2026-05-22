package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShopNowPage;
import pages.CartPage;
import utils.TestData;

public class CartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        LoginPage loginPage = new LoginPage(page);
        ShopNowPage shopNowPage = new ShopNowPage(page);
        CartPage cartPage = new CartPage(page);

        loginPage.login(
                TestData.EMAIL,
                TestData.PASSWORD
        );

        shopNowPage.clickShopNow();

        cartPage.addFirstProductToCart();

        cartPage.openCart();

        Assert.assertTrue(
                cartPage.getCartItems().count() > 0,
                "Cart is empty"
        );
    }
}