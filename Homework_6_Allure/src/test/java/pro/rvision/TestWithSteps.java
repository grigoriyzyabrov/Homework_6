package pro.rvision;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithSteps {
    @Step("Open main page")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Find repo")
    public void searchRepo(){
        $("[data-test-selector='nav-search-input']")
                .setValue("grigoriyzyabrov/Homework_6").pressEnter();

    }
    @Step("Open repo")
    public void openRepositoryPage(){
        $("[data-test-selector='nav-search-input']").setValue("grigoriyzyabrov/Homework_6")
                .pressEnter();

    }
    @Step("Find Issue")
    public void checkIssueButton(){
        attachPageSource();
        $("#issues-tab").should(Condition.visible);

    }

    @Attachment(value = "Screenshot",type = "text/html", fileExtension = "html")
    public byte[] attachPageSource(){
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }
}
