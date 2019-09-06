# smdesign
Cделать микросервис для электронного магазина с использованием SpringBoot/Hibernate и докеризовать его. Для базы можно использовать готовый образ.
Модель/cущности:
    Товар - отвечает за товар на складе, например - телефон такой-то марки от такого-то производителя.
    Поля:   
             идентификатор (ID)
             название
             описание
             параметры: массив пар ключ/значение
Сущности хранятся в MongoDB на localhost:27017

REST API методы:
Создать новый товар
Получить список названий товаров, с возможностью фильтрации по:
 a) названию
 b) выбранному параметру и его значению
Получить детали товара по ID
Методы принимают JSON на входе и отдают JSON на выходе.

1) Создать товар <br />
curl -X POST -H "Content-Type:application/json" -d '{"name": "test", "description": "test-descr", "parametres": {"test1": "value1", "test2":"value2"}}' http://localhost:8090/api/add_product
2) Фильтрация по имени товара <br />
curl -X GET "http://localhost/api/name_filter/{name}"
3) Получить весь список товаров <br />
curl -X GET "http://localhost/api/"
4) Получить информацию о продукте по id <br />
curl -X GET "http://localhost/api/{id}"
5) Фильтрация по параметру и значению <br />
curl -X GET "http://localhost/api/params_filter/{key}/{value}"

1) Для установки необходимо установить docker-compose:
sudo apt-get install docker-compose - на убунту
2) В корне директории проекта через терминал выполнить команду:
sudo docker-compose up
