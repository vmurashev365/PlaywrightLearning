package testcases;

import com.microsoft.playwright.*;

public class HandlingResizeBox {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/resources/demos/resizable/default.html");
        Locator boxresize = page.locator("(//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se'])[1]");
        page.mouse().move(boxresize.boundingBox().x + boxresize.boundingBox().width/2, boxresize.boundingBox().y + boxresize.boundingBox().height/2);
        page.mouse().down();
        Thread.sleep(2000);
        page.mouse().move(boxresize.boundingBox().x + 300, boxresize.boundingBox().y + 300);
        page.mouse().down();
        Thread.sleep(2000);
        page.mouse().move(boxresize.boundingBox().x - 100, boxresize.boundingBox().y - 100);
        page.mouse().up();

        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
