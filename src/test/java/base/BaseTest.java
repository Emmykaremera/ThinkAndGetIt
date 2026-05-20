package base;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeClass
    public void setup() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
        page.navigate("https://think-and-get-it-frontend.onrender.com/home");


    }
}