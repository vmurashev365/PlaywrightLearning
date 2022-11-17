package testcases;

import com.microsoft.playwright.*;

public class HandlingTabsPopups {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");

        Page popup = page.waitForPopup(() -> {
            page.locator("//a[@aria-label=\"Way2Automation's Privacy Policy\"]").click();

        });

        popup.locator("//a[@id='header-sign-up-btn']").click();
        popup.locator("#user_name").type("Victor Murashev");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        popup.close();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.close();
        browser.close();
        playwright.close();
    }
}
