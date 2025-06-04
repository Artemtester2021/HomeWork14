package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SelectySiteTests extends TestBase {

    @Test
    @Tag("demoqa")
    @DisplayName("Проверка отображения имени компании")
    void nameShouldBeVisibleTest() {
        step("Открытие главной страницы сайт организации", () -> {

            open(baseUrl);
        });

        step("Закрытие всплывающего банера куки", () -> {
            $(".close-cookie").click();
        });

        step("Отображение логотипа на главной странице", () -> {

            $("img[src='//hostkey.ru/hk/images/logo.svg']").shouldBe(visible);
        });
    }

    @Test
    @Tag("demoqa")
    @DisplayName("Переход в вкладку Распродажа")
    void toTheBankTabTest() {

        step("Открытие главной страницы сайт организации", () -> {
            open(baseUrl);
        });

        step("закрытие рекламного банера", () -> {
            $("#closingTopBanner").click();
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
    @Tag("demoqa")
    @DisplayName("Попытка входа в личный кабинет")
    void entranceToTheVirtualOfficeTest() {

        step("Открытие главной страницы сайт организации", () -> {
            open(baseUrl);
        });

        step("Переход в личный кабинет", () -> {
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
    @Tag("demoqa")
    @DisplayName("Не успешная авторизация")
    void notAutorethetionTest(){
        step("Открытие страницы авторизации", ()->{
            open("login/");
        });

        step("Заполнение поля логин", ()-> {
            $("#email").setValue("student@mail.ru");
        });

    }
}

