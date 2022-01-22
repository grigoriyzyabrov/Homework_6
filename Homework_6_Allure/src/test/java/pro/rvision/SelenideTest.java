package pro.rvision;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.util.EventListener;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @Test
    public void testIssueText(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $("[data-test-selector='nav-search-input']").setValue("grigoriyzyabrov/Homework_6").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#issues-tab").should(Condition.visible);

    }
}
