# DB in Java 

* JDBC (Java Database Connectivity) - технология работы с базами данных в java. Подразумевает наличие 
у каждой СУБД специального Java-архива (драйвера), который отвечает за подключение к 
конкретной БД.

* `java.sql` - пакет, в котором находятся классы и интерфейсы
для работы с БД в Java.

* `Connection` - интерфейс, объекты которого описывают
подключение к бд.

* `Statement` - интерфейс, объекты которого позволяют
выполнять запросы в БД и получать результат выполнения.

* `ResultSet` - интерфейс, объекты которого представляют
собой итераторы по результату запроса.