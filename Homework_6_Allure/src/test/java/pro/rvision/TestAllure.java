package pro.rvision;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestAllure {
    private static final String REPOSITORY = "grigoriyzyabrov/Homework_6";

    @Test
    public void lambdaStepsTest(){
        step ("Open page", () ->{
            open("https://github.com");
        });
        step ("Find repo" + REPOSITORY, () -> {
            $("[data-test-selector='nav-search-input']").setValue(REPOSITORY).pressEnter();
        });
        step ("Open repo" + REPOSITORY, () -> {
            $$("ul.repo-list li").first().$("a").click();
        });
        step ("Check Issue" + REPOSITORY, () -> {
            Allure.addAttachment("Page Source","text/html", WebDriverRunner.source(), "html");
            $("#issues-tab").should(Condition.visible);
        });

    }
    @Test
    public void annotationStepsTest(){
        TestWithSteps steps = new TestWithSteps();
        steps.openMainPage();
        steps.searchRepo();
        steps.openRepositoryPage();
        steps.checkIssueButton();
    }

    @AfterEach
    public void saveSources(){

    }
}
