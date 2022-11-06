package testcases;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        Playwright playwright = Playwright.create();
        //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        //Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe")));
        BrowserContext browserContext = browser.newContext( new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
        Page page = browserContext.newPage();
        page.navigate("https://way2automation.com");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.navigate("https://google.com");
        Thread.sleep(1000);
        page.goBack(new Page.GoBackOptions().setTimeout(500));
        Thread.sleep(1000);
        page.goForward(new Page.GoForwardOptions().setTimeout(500));
        Thread.sleep(1000);
        page.reload();
        Thread.sleep(1000);
        page.close();
        playwright.close();
    }
}
