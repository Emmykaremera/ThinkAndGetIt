package utils;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static Playwright playwright;

    public static Page createPage(String browserName) {

        playwright = Playwright.create();

        Browser browser;

        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        }

        BrowserContext context = browser.newContext();
        return context.newPage();
    }
}