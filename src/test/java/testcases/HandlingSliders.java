package testcases;

import com.microsoft.playwright.*;

public class HandlingSliders {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/resources/demos/slider/default.html");
        Locator slider = page.locator("(//div[@id='slider'])[1]");
        page.mouse().move(slider.boundingBox().x + slider.boundingBox().width/2, slider.boundingBox().y + slider.boundingBox().height/2);
        page.mouse().down();
        Thread.sleep(4000);
        page.mouse().down();
        page.mouse().move(slider.boundingBox().x + 300, slider.boundingBox().y + slider.boundingBox().height);
        Thread.sleep(4000);
        page.mouse().move(slider.boundingBox().x + 800, slider.boundingBox().y + slider.boundingBox().height);
        page.mouse().up();



        Thread.sleep(4000);
        page.close();
        browser.close();
        playwright.close();
    }
}
