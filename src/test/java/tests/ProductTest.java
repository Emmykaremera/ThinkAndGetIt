package tests;

import actions.ProductActions;
import com.microsoft.playwright.Page;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;
import utils.PlaywrightFactory;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductTest {

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})

    public void navigateToProductPage(String browserName) {
        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigReader.getProperty("base.url"));
        ProductActions product = new ProductActions(page);

        product.navigateToProductPageAsUser();

        assertThat(page)
                .hasURL(ConfigReader.getProperty("base.url") + "/products");

        assertThat(product.sortDropdown())
                .isVisible();

        page.context().browser().close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    public void dropdownIsVisible(String browserName) {

        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigReader.getProperty("base.url"));
        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsUser();

        assertThat(product.sortDropdown())
                .isVisible();

        assertThat(product.sortDropdown())
                .isEnabled();

        page.context().browser().close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    public void sortByNewest(String browserName) {

        Page page = PlaywrightFactory.createPage(browserName);
        page.navigate(ConfigReader.getProperty("base.url"));
        ProductActions product = new ProductActions(page);
        product.navigateToProductPageAsUser();
        product.sortProductsBy("newest");

        assertThat(product.sortDropdown())
                .hasValue("newest");

        page.context().browser().close();
    }
}