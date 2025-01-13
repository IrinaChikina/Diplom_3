
# **Дипломная работа**

### Задание№3  
## ***UI - тестирование на часть функциональности веб-приложение [Stellar Burgers](https://stellarburgers.nomoreparties.site).***
![десктопная версия](window.jpg)
###### В ходе выполнения дипломной работы были использованы следующие технологии:
    - Java 11
    - JUnit 4
    - Maven 3.9
    - Selenium 4

[ ] Тестовые данные для проверки тестов сгенерированы с помощью `JavaFaker`
[ ] Создание новых пользователей для тестирования прилодения выполнялось по средствам API при помощи библиотеки `Rest-Assured` и `Google Gson` 
[ ] Кросбраузерное тестирование реализовано с помощью библиотеки `WebDriverManager` в браузерах:
  - Google Chrome
  - Yandex
Для запуска тестов через Yandex:
`mvn clean test -Dbrowser=yandex -Ddriver.version=130.0.6723.116 -Dwebdriver.yandex.bin=/Applications/Yandex.app/Contents/MacOS/Yandex`

[ ] Реалезован `паралельный запуск` двух тестов на полный экран
[ ] При помощи фреймворка `Allure` визуализирован отчёты о тестировании.

Все автотесты расположены в папке [test/java](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/test/java)
В папке [main/java](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/main/java) расположены вспомогательные классы с [константами](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/main/java/Constants.java), класс [Start](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/main/java/Start.java)для запуска браузера и класс [CreatingUser](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/main/java/CreatingUser.java) с методами для создания пользователей,
а так же пакет [PageObject](/Users/irinachikina/Diplom_Irina_Chikina_40/Diplom_3/src/main/java/PageObject) с локатарам и их методами разделенные постранично 
![десктопная версия](window.jpg)