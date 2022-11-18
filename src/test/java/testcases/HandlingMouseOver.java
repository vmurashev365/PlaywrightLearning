package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingMouseOver {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.way2automation.com/");

        page.locator("(//span[@class='menu-text'][normalize-space()='All Courses'])[1]").hover();
        page.locator("(//span[@class='menu-text'][normalize-space()='DevOps'])[1]").click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();

    }
}
