package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

public class CartPage {

    private final Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public void addFirstProductToCart() {

        page.waitForTimeout(2000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Quick Add")).nth(2).click();

    }

    public void openCart() {
        page.locator("a:has-text('Cart')")
                .click();
    }

    public Locator getCartItems() {
        return page.locator(".cart-item, .item, .product");
    }

    public Locator getCartCount() {
        return page.locator(".cart-count, .cart-badge, .badge");
    }
}