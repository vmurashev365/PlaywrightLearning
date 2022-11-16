package testcases;

import com.microsoft.playwright.*;

public class HandlingCheckboxes {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");
        Locator block = page.locator("(//div[@class='display'])[1]");
        Locator checkboxes = block.locator("[type='checkbox']");

        for (int i=0; i< checkboxes.count(); i++) {
            checkboxes.nth(i).click();
        }
        System.out.println(checkboxes.count());
        Thread.sleep(5000);

        page.close();
        playwright.close();
    }
}
