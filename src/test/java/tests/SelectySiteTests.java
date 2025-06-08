package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("hostkey")
public class SelectySiteTests extends TestBase {

    @Test
    @DisplayName("Проверка отображения логотипа компании")
    void nameShouldBeVisibleTest() {
        step("Открытие главной страницы сайт организации", () -> {
            open(baseUrl);
        });
        step("закрытие рекламного банера", () -> {
            $("#closingTopBanner").click();
        });
        step("Закрытие всплывающего банера куки", () -> {
            $(".close-cookie").click();
        });
        step("Отображение логотипа на главной странице", () -> {
            $("img[src='//hostkey.ru/hk/images/logo.svg']").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Переход в раздел 'Распродажа'")
    void toTheBankTabTest() {
        step("Открытие главной страницы сайт организации", () -> {
            open(baseUrl);
        });
        step("закрытие рекламного банера", () -> {
            $("#closingTopBanner").click();
        });
        step("Закрытие всплывающего банера куки", () -> {
            $(".close-cookie").click();
        });
        step("Переход в вкладку Распродажа", () -> {
            $("[href='https://hostkey.ru/dedicated-servers/cheap/']").click();
        });
        step("Отображение заголовка в вкладке", () -> {
            $(".primary-block__text-block").scrollTo().shouldBe(visible);
            $("h1").shouldHave(exactText("Распродажа готовых выделенных серверов"));
        });
    }

    @Test
    @DisplayName("Кликабельность вкладки прокат")
    void openingTheRentalTab() {
        step("Открытие главной страницы сайт организации", () -> {
            open(baseUrl);
        });
        step("Переход в вкладку прокат", () -> {
            $("[href='/server-away/']").click();
        });
        step("закрытие рекламного банера", () -> {
            $("#closingTopBanner").click();
        });
        step("Закрытие всплывающего банера куки", () -> {
            $(".close-cookie").click();
        });
        step("Нажатие кнопки 'собрать сервер'", () -> {
            $(".position-relative").click();
        });
    }

    @Test
    @DisplayName("Не успешная авторизация")
    void notAutorethetionTest() {
        step("Открытие страницы авторизации", () -> {
            open("/login/");
        });
        step("закрытие рекламного банера", () -> {
            $("#closingTopBanner").click();
        });
        step("Закрытие всплывающего банера куки", () -> {
            $(".close-cookie").click();
        });
        step("Заполнение поля логин", () -> {
            $("#email").setValue("student@mail.ru");
        });
        step("Заполнение поля пароль", () -> {
            $("#password").setValue("1234567");
        });
        step("клик по кнопке 'войти'", () -> {
            $("#password").scrollTo();
            $("button.hk-login-btn").click();
        });
        step("Проверка предупреждения при некорректном заполнении полей авторизации", () -> {
            $$(".primary-block__title center_h1").findBy(text("О компании HOSTKEY"));
        });
    }

    @Test
    @DisplayName("Проверка раздела 'О нас'")
    void openingTheAboutUsTabTest(){
        step("Переход в раздел 'О нас'", () -> {
            open("/about-us/");
        });
        step("закрытие рекламного банера", () -> {
            $("#closingTopBanner").click();
        });
        step("Закрытие всплывающего банера куки", () -> {
            $(".close-cookie").click();
        });
        step("Проверка отображения заголовка раздела", () -> {
            $$(".validation-prompt login-error").findBy(text("Адрес электронной почты или пароль указаны неверно"));
        });
    }

}

