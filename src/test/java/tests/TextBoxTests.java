package tests;


import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; //размер экрана
        Configuration.baseUrl = "https://demoqa.com"; //абсолютный
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true; // не закрывает браузер
        Configuration.timeout = 6000; //default 4000 = 4 sek
    }

    @Test
    void fillFormTest() {
        open("/text-box"); //относительный
        $("#userName").setValue("Zhadyra");
        $("#userEmail").setValue("test@gmail.com");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Zhadyra"));
        $("#output #email").shouldHave(text("test@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}
