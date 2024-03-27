package guru.qa.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidWikipediaTests extends TestBase {

    @Test
    @DisplayName("Search results are displayed")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("An article is displayed")
    void openArticleFromMainPageTest() {
        step("Click on article header ", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/horizontal_scroll_list_item_text")).click());
        step("Check opening", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/view_news_fullscreen_link_card_list"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}
