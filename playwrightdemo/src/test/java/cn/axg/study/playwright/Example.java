package cn.axg.study.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.MouseButton;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Example {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();
            page.navigate("https://tpass.zhejiang.chinatax.gov.cn:8443/#/login?redirect_uri=https%3A%2F%2Fetax.zhejiang.chinatax.gov.cn%2Fzjgfdzswj%2Fmain%2Fkx%2Fskip.html%3Fservice%3Dhttps%3A%2F%2Fetax.zhejiang.chinatax.gov.cn%2Fzjgfdzswj%2Fmain%2Fhome%2Fwdxx%2Findex.html");
            page.navigate("https://etax.zhejiang.chinatax.gov.cn/zjgfdzswj/main/index.html");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("确定")).click();
            page.locator("#loginopen").click();
            page.getByPlaceholder("统一社会信用代码/纳税人识别号").click();
            page.getByPlaceholder("统一社会信用代码/纳税人识别号").fill("91330681669188850J");
            page.getByPlaceholder("居民身份证号码/手机号码/用户名").click();
            page.getByPlaceholder("居民身份证号码/手机号码/用户名").fill("15957575138");
            page.getByPlaceholder("个人用户密码").click();
            page.getByPlaceholder("个人用户密码").fill("a1234567");



//            page.frameLocator("").locator("").setInputFiles();

//            page.click();
//            page.reload();


//            String js = "var slider = document.getElementById(\"btn_handler\");\n  " +
//                    "    var rect = slider.getBoundingClientRect(), x0 = rect.x || rect.left, y0 = rect.y || rect.top, x1 = x0 + 500, y1 = y0;\n   " +
//                    "    var mousedown = document.createEvent('MouseEvents');\n   " +
//                    "    mousedown.initMouseEvent('mousedown', true, true, window, 0, x0, y0, x0, y0, false, false, false, false, 0, null);\n   " +
//                    "    slider.dispatchEvent(mousedown);\n   " +
//                    "    var mousemove = document.createEvent('MouseEvents');\n   " +
//                    "    mousemove.initMouseEvent('mousemove', true, true, window, 0, x1, y1, x1, y1, false, false, false, false, 0, null);\n  " +
//                    "    slider.dispatchEvent(mousemove);\n   " +
//                    "    var mouseout = document.createEvent('MouseEvents');\n   " +
//                    "    mouseout.initMouseEvent('mouseout', true, true, window, 0, x1, y1, x1, y1, false, false, false, false, 0, null);\n   " +
//                    "    slider.dispatchEvent(mouseout);";
//            String addId = "document.getElementsByClassName('handler')[0].setAttribute(\"id\",\"btn_handler\")";
//            page.evaluate(addId);
//            page.evaluate(js);


            BoundingBox slider = page.locator(".handler").boundingBox();
            page.mouse().move(slider.x + slider.width /2,slider.y+slider.height/2);
            page.mouse().down();
            page.mouse().move(slider.x + slider.width /2 + 500,slider.y+slider.height /2);
            page.mouse().up();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("登录")).click();

//            page.navigate("https://dppt.zhejiang.chinatax.gov.cn:8443/invoice-query/invoice-query");
//

            page.waitForLoadState();
            page.getByText("确定").click();

            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("我要查询")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("发票信息查询")).click();
            page.locator("td").filter(new Locator.FilterOptions().setHasText("通用机打发票增值税电子普通发票浙江省通用电子")).getByRole(AriaRole.BUTTON).click();
            page.getByRole(AriaRole.LISTBOX).getByRole(AriaRole.OPTION, new Locator.GetByRoleOptions().setName("二手车发票")).click();

            Thread.sleep(10000);

//            try {
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("我要办税")).click();
//                Page page1 = page.waitForPopup(() -> {
//                    page.getByTitle("税务数字账户").click();
//                });
//            } catch (Exception e) {
//                System.out.println("切换页面地址出错！！！！");
//            }


//            File file = new File("D:\\project\\cloud-study\\playwrightdemo\\src\\main\\resources\\111.txt");
//
//            try {
//                file.createNewFile();
//                FileWriter fileWriter = new FileWriter(file);
//                fileWriter.write(page.content());
//                fileWriter.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }finally {
//
//            }
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
