package testcases;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.awt.List;


public class HandlingDropdownList {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org");
        //select by value
        //page.selectOption("select", "et");
        //select by text
        page.selectOption("select", new SelectOption().setLabel("Dansk"));
        //select by index
        page.selectOption("select", new SelectOption().setIndex(1));

        //getting count of options
        Locator values = page.locator("select > option");
        System.out.println("Number of options = " + values.count());

        //getting text of options and language attributes
        for (int i=0; i<values.count(); i++) {
            System.out.println(values.nth(i).innerText() + "-------" + values.nth(i).getAttribute("lang"));
        }

    }
}
