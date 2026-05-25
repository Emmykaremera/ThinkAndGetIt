package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.Test;

public class RegistrationPage {

    private final Page page;

    public RegistrationPage(Page page) {
        this.page = page;
    }

    public void navigateToRegistrationPage() {
        page.navigate("https://think-and-get-it-frontend.onrender.com/register");

    }

    public void createAccount(String firstName, String lastName, String email, String password) {
        page.navigate("https://think-and-get-it-frontend.onrender.com/register");
        page.waitForSelector("input[placeholder='John']");
        page.fill("input[placeholder='John']", firstName);
        page.fill("input[placeholder='Doe']", lastName);
        page.fill("input[type='email']", email);
        page.fill("input[type='password']", password);

        page.click("button[type='submit']");

    }

    public String getCurrentUrl() {
        return page.url();
    }

    public boolean isMessageVisible(String message) {
        return page.getByText(message).isVisible();
    }
}