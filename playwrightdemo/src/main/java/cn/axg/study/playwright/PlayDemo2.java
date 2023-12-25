package cn.axg.study.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;

public class PlayDemo2 {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.baidu.com/");
            page.locator("#kw").click();
            page.locator("#kw").fill("美女");
            page.locator("#kw").press("Enter");
            Page page1 = page.waitForPopup(() -> {
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("美女 - 百度图片")).click();
            });
            Page page2 = page1.waitForPopup(() -> {
                page1.locator("li").filter(new Locator.FilterOptions().setHasText("美女图集 1080 x 1439")).getByRole(AriaRole.LINK).first().click();
            });
            Download download = page2.waitForDownload(() -> {
                page2.locator("#srcPic").getByRole(AriaRole.IMG).click(new Locator.ClickOptions()
                        .setButton(MouseButton.RIGHT));
            });
        }
    }
}
