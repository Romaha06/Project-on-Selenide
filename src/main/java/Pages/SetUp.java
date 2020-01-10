package Pages;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class SetUp {

    public void openUrl(String url) {
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
//        Configuration.pageLoadStrategy = "none";
        open(url);
        System.out.println("Page was opened.");
    }
}
