package testcases;

import com.microsoft.playwright.*;

public class HandlingLinks {
    public static void main(String[] args) throws InterruptedException {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");
        Locator links = page.locator("a");

        //return all links-count and all links
        /*System.out.println(links.count());
        for (int i=0; i < links.count(); i++){
            System.out.println(links.nth(i).innerText() + "---URL---" + links.nth(i).getAttribute("href"));
        }*/

        //return links under block

        Locator block = page.locator("(//div[@class='footer'])[1]");
        Locator blockLinks = block.locator("a");
        System.out.println("Print locators in the block");
        System.out.println(blockLinks.count());
        for (int i=0; i < blockLinks.count(); i++){
            System.out.println(blockLinks.nth(i).innerText() + "---URL---" + blockLinks.nth(i).getAttribute("href"));
        }
        blockLinks.nth(4).click();
        Thread.sleep(5000);

        page.close();
        playwright.close();
    }
}
