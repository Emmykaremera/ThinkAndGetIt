package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {

    private Page page;

    public ProductPage(Page page) {
        this.page = page;
    }


    private String startShoppingBtn = "a.btn-primary.text-base.py-4.px-8.flex.items-center.gap-2.glow-red";

    private String shopNowLink = "a.btn-primary.py-4.px-8.flex.items-center.gap-2.text-base.glow-red[href='/products']";


    private String sortDropdown = "select.input.py-2.pr-8.pl-3.text-sm.appearance-none.cursor-pointer";



    private String productCards = ".group.card-hover.block";



    private String priceMinInput = "input[placeholder='Min']";

    private String priceMaxInput = "input[placeholder='Max']";

    private String noResultsMessage = "text=No products found";

    private String clearAllFilters = "text=Clear all filters";



    public void clickStartShopping() {
        page.click(startShoppingBtn);
    }

    public void clickShopNow() {
        page.click(shopNowLink);
    }

    public void navigateToProductsPage() {
        clickStartShopping();
        clickShopNow();
    }



    public void selectSortOption(String value) {
        page.selectOption(sortDropdown, value);
    }

    public Locator getSortDropdown() {
        return page.locator(sortDropdown);
    }



    public Locator category(String category) {
        return page.locator("//button[normalize-space()='Bags & Luggage']");
    }

    public Locator size(String size) {
        return page.locator("text=" + size).first();
    }

    public Locator color(String color) {
        return page.locator("button[title='" + color + "']").first();
    }

    public Locator special(String special) {
        return page.locator("text=" + special).first();
    }



    public void selectCategory(String category) {
        category(category).click();
    }

    public void setPriceRange(double min, double max) {

        page.locator(priceMinInput)
                .fill(String.valueOf(min));

        page.locator(priceMaxInput)
                .fill(String.valueOf(max));

        page.locator(priceMaxInput)
                .press("Enter");
    }

    public void selectSize(String size) {
        size(size).click();
    }

    public void selectColor(String color) {
        color(color).click();
    }

    public void selectSpecial(String special, boolean enable) {

        if (special(special).isChecked() != enable) {
            special(special).click();
        }
    }



    public boolean areAllProductsOfSelectedCategory(String category) {

        Locator visibleProducts =
                page.locator(productCards)
                        .filter(
                                new Locator.FilterOptions()
                                        .setVisible(true)
                        );

        int count = visibleProducts.count();

        for (int i = 0; i < count; i++) {

            String productText =
                    visibleProducts.nth(i)
                            .textContent()
                            .trim();

            if (!productText.contains(category)) {
                return false;
            }
        }

        return true;
    }

    public boolean areAllProductsOfSelectedPriceRange(double min, double max) {

        Locator visibleProducts =
                page.locator(productCards)
                        .filter(
                                new Locator.FilterOptions()
                                        .setVisible(true)
                        );

        int count = visibleProducts.count();

        for (int i = 0; i < count; i++) {

            String productText =
                    visibleProducts.nth(i)
                            .textContent();

            String priceText =
                    productText.replaceAll(
                            ".*\\$(\\d+\\.\\d+).*",
                            "$1"
                    );

            double price =
                    Double.parseDouble(priceText);

            if (price < min || price > max) {
                return false;
            }
        }

        return true;
    }

    public boolean areAllProductsOfSelectedColor(String color) {

        Locator visibleProducts =
                page.locator(productCards)
                        .filter(
                                new Locator.FilterOptions()
                                        .setVisible(true)
                        );

        int count = visibleProducts.count();

        for (int i = 0; i < count; i++) {

            String productText =
                    visibleProducts.nth(i)
                            .textContent()
                            .trim();

            if (!productText.contains(color)) {
                return false;
            }
        }

        return true;
    }

    public int getProductCount() {
        return page.locator(productCards).count();
    }

    public boolean hasProducts() {
        return getProductCount() > 0;
    }

    public boolean isNoResultsDisplayed() {
        return page.locator(noResultsMessage).isVisible();
    }

    public void clearAllFilters() {
        page.locator(clearAllFilters).click();
    }
}