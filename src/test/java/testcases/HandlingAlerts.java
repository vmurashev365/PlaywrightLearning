package testcases;

import com.microsoft.playwright.*;

public class HandlingAlerts {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");
        page.onDialog(dialog -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            dialog.accept();
            System.out.println(dialog.message());
        });
        page.locator("[type='submit']").click();

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
