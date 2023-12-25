package cn.axg.study.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayDemo01 {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.baidu.com/");
        page.fill("//*[@id=\"kw\"]","美女");
        page.click("//*[@id=\"su\"]");

        Thread.sleep(1000);

        page.click("//*[@id=\"content_left\"]/div[1]/div[1]/h3/a");

        Thread.sleep(100000);

        browser.close();


    }
}
