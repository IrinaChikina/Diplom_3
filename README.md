
## **Дипломная работа**

#### Задание№3  
### ***UI - тестирование на часть функциональности веб-приложение [Stellar Burgers](https://stellarburgers.nomoreparties.site).***
![десктопная версия](window.jpg)
##### В ходе выполнения дипломной работы были использованы следующие технологии:
- Java 11
- JUnit 4
- Maven 3.9
- Selenium 4

:heavy_check_mark: Тестовые данные для проверки тестов сгенерированы с помощью `JavaFaker`  
:heavy_check_mark: Создание новых пользователей и их удаление выполнялется по средствам API при помощи библиотеки `Rest-Assured` и `Google Gson`  
:heavy_check_mark: Кроссбраузерное тестирование реализовано с помощью библиотеки `WebDriverManager` в браузерах:
  - Google Chrome  
  - Yandex  
Для запуска тестов через Yandex:
`mvn clean test -Dbrowser=yandex -Ddriver.version=130.0.6723.116 -Dwebdriver.yandex.bin=/Applications/Yandex.app/Contents/MacOS/Yandex`

:heavy_check_mark: Реализован `паралельный запуск` двух тестов на полный экран  
:heavy_check_mark: При помощи фреймворка `Allure` визуализирован отчёты о тестировании.  
:heavy_check_mark: Для сокращения шаблонного кода испольщована библиотека `Lombok`  
Все автотесты расположены в папке [test/java](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/test/java)  
Автоматическое закрытие и открытие браузера описано в классе [Base](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/test/java/Base.java)  
В папке [main/java](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/main/java) расположены вспомогательные классы с [константами](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/main/java/Constants.java),
класс [Start](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/main/java/Start.java) для запуска браузера и класс [CreatingUser](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/main/java/CreatingUser.java) с методами для создания пользователей,
а так же пакет [PageObject](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/main/java/PageObject) с локаторами и их методами разделенные постранично.
