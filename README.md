# ExchangeRates
This is a demonstration project for the interview


**Maven Project
Spring Boot 3.0.2
Java 17
MySQL DB

Dependencies:
Spring Web
Lombok
Thymeleaf
MySQL Driver
Spring Data JPA


//local tomcat server address
http://localhost:8080/web-exchange-rate-list/listAll



DB create scripts:

DROP DATABASE  IF EXISTS exchange_rates_DB;

CREATE DATABASE  IF NOT EXISTS exchange_rates_DB;
USE exchange_rates_DB;

DROP TABLE IF EXISTS exchange_rates;
CREATE TABLE exchange_rates (
  id int(11) NOT NULL AUTO_INCREMENT,
  short_name varchar(5) NOT NULL,
  valid_from datetime NOT NULL,
  name varchar(150) NOT NULL,
  country varchar(150) NOT NULL,
  move double NOT NULL,
  amount int NOT NULL,
  val_buy double NOT NULL,
  val_sell double NOT NULL,
  val_mid double NOT NULL,
  curr_buy double NOT NULL,
  curr_sell double NOT NULL,
  curr_mid double NOT NULL,
  version int NOT NULL,
  cnb_mid double NOT NULL,
  ecb_mid double NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





zadani:
Ukládání a náhled kurzovních lístků
Cílem je vytvořit aplikaci, která pracuje s kurzovními lístky.
Zadání má dvě části. FE část, která se zaměřuje na tvorbu frontendového řešení (HTML,
JavaScript / Angular / React) a BE část, která se zaměřuje na tvorbu backendu a aplikační
logiky.

FE:
Vytvořte FE aplikaci pomocí React / Angular nebo HTML a JS. Aplikace má dvě
obrazovky. Jedna, která získá z API pomocí GET requestu kurzovní lístky a zobrazí je.
Druhá, která zobrazí detail konkrétního kurzovního lístku.
Kurzovní lístky jsou dostupné zde:
https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerat
es?web-api-key=c52a0682-4806-4903-828f-6cc66508329e

BE:
Vytvořte Enterprise Java Aplikaci či SpringBoot java. Aplikace bude mít jedno REST API,
které vrátí kurzovní lístky. REST API rozeznává jeden parametr, který se mu posílá jako
query atribut a má název usedb s možnými hodnoty (true nebo false). V případě true, vrátí
data z DB. V případě false, se vaše aplikace dotáže pro aktuální seznam kurzovních lístků
systému v České spořitelně, pomocí http dotazu: Metoda GET:
https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerat
es?web-api-key=c52a0682-4806-4903-828f-6cc66508329e a tyto hodnoty si uloží do
databáze (DB může být libovolná).

FE druhá část:
Po implementaci BE části proveďte na FE takové změny, aby se kurzovní lístky
nestahovali přímo z České spořitelny, ale z vašeho lokálního BE.
Umístění zdrojových kódů a postup:
Zdrojové kódy umístěte na GITHUB – stačí veřejný profil, zadání není nic tajného. Pro
vytvoření balíčku aplikace využijte Maven či Gradle. Aplikaci lze postavit na spring bootu
či na libovolném jiném framework. Dejte nám prosím vědět, až dokončíte implementaci.**
