package NewPackage;

import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class New  extends ChromeRunner {
    @Test
    public static void test(){
        $(byLinkText("Create new account")).click();
        $(byName("firstname")).setValue("Nika");
        $(byName("lastname")).setValue("Gelovani");
        Assert.assertEquals($(byName("lastname")).getValue(), "Gelovani");
        $(byName("reg_email__")).setValue("nikagelo@gmail.com");
        $(byName("reg_passwd__")).setValue("Test123");
        $(byName("birthday_month")).selectOption("Jun");
        SoftAssert soft = new SoftAssert();
        $(byName("birthday_day")).selectOption("28");
        soft.assertEquals($(byName("birthday_day")).getValue(), "28");
        $(byName("birthday_year")).selectOption("2000");
        $(byText("Custom")).click();
        $(byText("Select your pronoun")).shouldBe(Condition.visible);
        $(byName("custom_gender")).shouldBe(Condition.visible);
        $(byName("preferred_pronoun")).selectOption("He: \"Wish him a happy birthday!\"");
        $(byText("Male")).click();
        $(byText("Select your pronoun")).shouldNotBe(Condition.visible);
        $(byName("custom_gender")).shouldNotBe(Condition.visible);
        sleep(3000);
        soft.assertAll();

    }
}
