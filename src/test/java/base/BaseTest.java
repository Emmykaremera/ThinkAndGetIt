package base;

import com.microsoft.playwright.*;

import com.microsoft.playwright.*;
import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;
import utils.Endpoints;

public class BaseTest {

    protected static Playwright playwright;
    protected static Browser browser;
    public static Page page;

    @BeforeClass
    public void setup() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        page = browser.newPage();

        String baseUrl = ConfigReader.getProperty("base.url");

        page.navigate(baseUrl);
    }

//    @AfterClass
//    public static void tearDown() {
//
//        page.close();
//
//        browser.close();
//
//        playwright.close();
//    }
}