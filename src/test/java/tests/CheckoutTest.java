package tests;

import base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;
import static tests.CartTest.addToCartTest;

public class CheckoutTest extends BaseTest {
    @Test
    public void checkoutTes(){
        addToCartTest();

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Checkout")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue to Payment")).click();
        page.getByText("💵Cash on DeliveryPay when").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Review Order")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place Order")).click();
        page.waitForTimeout(10000);
        boolean successfulMessage = page.getByText("Order placed successfully").isVisible();
        assertTrue(successfulMessage);

    }
}
