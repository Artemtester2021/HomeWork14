# Проект по автоматизации тестовых сценариев для сайта [hostkey](https://hostkey.ru/)
<p align="center">
  <a href="https://hostkey.ru/" target="_blank">
    <img src="media/screenshots/logo.svg" width="200" alt="hostkey Logo">
  </a>
</p>
## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :computer: Используемый стек

<p align="center">
  <a href="https://www.jetbrains.com/idea/" target="_blank"><img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg"></a>
  <a href="https://www.java.com/" target="_blank"><img width="6%" title="Java" src="media/logo/Java.svg"></a>
  <a href="https://selenide.org/" target="_blank"><img width="6%" title="Selenide" src="media/logo/Selenide.svg"></a>
  <a href="https://aerokube.com/selenoid/" target="_blank"><img width="6%" title="Selenoid" src="media/logo/Selenoid.svg"></a>
  <a href="https://github.com/allure-framework/allure2" target="_blank"><img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg"></a>
  <a href="https://gradle.org/" target="_blank"><img width="6%" title="Gradle" src="media/logo/Gradle.svg"></a>
  <a href="https://junit.org/junit5/" target="_blank"><img width="6%" title="JUnit5" src="media/logo/JUnit5.svg"></a>
  <a href="https://github.com/" target="_blank"><img width="6%" title="GitHub" src="media/logo/GitHub.svg"></a>
  <a href="https://www.jenkins.io/" target="_blank"><img width="6%" title="Jenkins" src="media/logo/Jenkins.svg"></a>
  <a href="https://telegram.org/" target="_blank"><img width="6%" title="Telegram" src="media/logo/Telegram.svg"></a>
</p>

Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/), сборщик - <code>Gradle</code>. <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
При прогоне тестов для запуска браузеров используется [Selenoid](https://aerokube.com/selenoid/).
Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
```
gradle clean demoqa_test
```
При выполнении данной команды в терминале IDE тесты запустятся удаленно в <code>Selenoid</code>.


## [<img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> Сборка в Jenkins](https://jenkins.autotests.cloud/job/qa.guru_grup_35_ArtemZ14/)

Для запуска сборки необходимо перейти в раздел <code>Build with Parameters</code> и нажать кнопку <code>Build</code>.
<p align="center">
<img title="Jenkins Build" src="media/screenshots/jenkins.png">
</p>
После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клиике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.

## [<img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> Пример Allure-отчета](https://jenkins.autotests.cloud/job/qa.guru_grup_35_ArtemZ14/6/allure/)
### Overview

<p align="center">
<a <img title="Allure Overview" src="media/screenshots/Allure.png">
</p>


### Результат выполнения автотеста

<p align="center">
<img title="Test Results in Alure TestOps" src="media/screenshots/allurResults.png">
</p>



### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screenshots/Bot.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
<p align="center">
  <img title="Selenoid Video" src="media/screenshots/Video.gif">
</p>
