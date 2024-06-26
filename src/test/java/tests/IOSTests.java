package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("ios")
public class IOSTests extends TestBase {
    @Test
    void successfulFirstPageOpeningTest() {
        step("Click on Text button", () -> {
            $(accessibilityId("Text Button")).click();
        });

        step("Click on text search field & insert value", () -> {
            $(accessibilityId("Text Input")).click();
            $(accessibilityId("Text Input")).sendKeys("Selenide");
            $(accessibilityId("Text Input")).pressEnter();
        });

        step("Verify output text", () -> {
            $(id("Text Output")).shouldHave(Condition.text("Selenide"));
        });
    }

}

