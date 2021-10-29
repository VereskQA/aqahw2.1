package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AppOrderTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $(".form.form_size_m.form_theme_alfa-on-white");
        form.$("[data-test-id=name] input").setValue("Сергеев Игорь");
        form.$("[data-test-id=phone] input").setValue("+79205826217");
        form.$("[data-test-id=agreement]").click();
        form.$(".button.button_view_extra").click();
        $("[data-test-id=\"order-success\"]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш" +
                " менеджер свяжется с вами в ближайшее время."));
    }
}

