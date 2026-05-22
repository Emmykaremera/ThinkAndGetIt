package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ShopNowPage {

    private final Page page;

    public ShopNowPage(Page page) {
        this.page = page;
    }

    public void clickShopNow() {
        page.locator("a.glow-red").click();
    }

    public void selectOption(String value) {
        page.locator("select.input.cursor-pointer").selectOption(value);
    }

    public Locator getSortDropdown() {
        return page.locator("select.input.cursor-pointer");
    }

    public void addFirstProduct() {
        page.locator("button:has-text('Add to Cart')")
                .first()
                .click();
    }
}