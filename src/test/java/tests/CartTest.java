package tests;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ShopNowPage;
import pages.CartPage;
import utils.TestData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartTest extends BaseTest {

    @Test
    public static void addToCartTest() {

        LoginPage loginPage = new LoginPage(page);
        ShopNowPage shopNowPage = new ShopNowPage(page);
        CartPage cartPage = new CartPage(page);

        loginPage.login(
                TestData.EMAIL,
                TestData.PASSWORD
        );


        shopNowPage.clickShopNow();

        cartPage.addFirstProductToCart();


        Locator cartItem = page.getByText("Clear PVC Stadium Tote Bag");
        assertThat(cartItem).isVisible();

    }
}