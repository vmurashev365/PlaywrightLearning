package testcases;

import com.microsoft.playwright.*;

public class TestLocators {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("http://gmail.com");
        //page.locator("#identifierId").type("vmurashev@gmail.com");
        //page.locator("//input[@id='identifierId']").type("vmurashev@gmail.com");
        //page.type("#identifierId", "vmurashev@gmail.com");
        //page.type("#identifierId", "vmurashev@gmail.com", new Page.TypeOptions().setDelay(100));
        page.type("[type=email]", "vmurashev@gmail.com");
        //page.click("(//span[normalize-space()='Next'])[1]");
        //page.click("text=Next");
        page.click("button:has-text('Next')");
        page.locator("[type=password]").fill("Adonai123");
        page.click("button:has-text('Next')");
    }

}
