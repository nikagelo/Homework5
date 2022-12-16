package Utils;

import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public class ChromeRunner {
    @BeforeTest

    public static void setUp(){

        open("https://www.facebook.com/");
    }

}
