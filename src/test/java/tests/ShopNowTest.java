package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ShopNowPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShopNowTest extends BaseTest {

    @Test
    public void testSorting() {

        ShopNowPage shopNow = new ShopNowPage(page);

        shopNow.clickShopNow();

        shopNow.selectOption("newest");
        assertThat(shopNow.getSortDropdown()).hasValue("newest");

        shopNow.selectOption("popular");
        assertThat(shopNow.getSortDropdown()).hasValue("popular");

        shopNow.selectOption("price_asc");
        assertThat(shopNow.getSortDropdown()).hasValue("price_asc");

        shopNow.selectOption("price_desc");
        assertThat(shopNow.getSortDropdown()).hasValue("price_desc");

        shopNow.selectOption("rating");
        assertThat(shopNow.getSortDropdown()).hasValue("rating");
    }
}