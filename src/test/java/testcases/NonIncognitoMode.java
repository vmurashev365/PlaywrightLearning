package testcases;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class NonIncognitoMode {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe")));
        Page page = browserContext.newPage();
        page.navigate("https://way2automation.com");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        playwright.close();

    }
}

