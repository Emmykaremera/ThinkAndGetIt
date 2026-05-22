package pages;
import com.microsoft.playwright.Page;
import utils.ConfigReader;
import utils.Endpoints;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page){

        this.page = page;
    }

    public void login(String username, String password){

        page.navigate(
                ConfigReader.getProperty("base.url")
                        + Endpoints.LOGIN
        );

        page.locator("input")
                .first()
                .fill(username);

        page.locator("input")
                .nth(1)
                .fill(password);

        page.locator("button[type='submit']")
                .click();
    }
}