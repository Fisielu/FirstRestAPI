Podstawową klasą jest _FirstRestApiApplication_, inicjalizuje ona Spring Boota, który zarządza apką, uruchamia niezbędne elementy (serwer, SQLa czy inne dociągnięte repo).



Api

_ProductController_ - odpowiada za koordynowanie zapytań HTML, z racji na rodzaj zapytania rozpisujemy przekierowania do odpowiedniej klasy request lub response, sama instrukcja zapytania realizowana jest w _ProductService_.
Zwraca odpowiedź apki oraz status HTTP informujący czy realizaja polecenia przebiegła pomyślnie.



Request
_ProductRequest_ - klasa która przepisuje żądanie HTML na obiekt tej klasy, dzięki czemu możemy potem nim manipulować w obrębie aplikacji.

_UpdateProductRequest_ - klasa która dziedziczy po _ProductRequest_, działanie tożsame do klasy nadrzędnej.



Response

_ProductResponse_ - tak jak obiekty klasy _ProductRequest_ i _UpdateProductRequest_ przechowywują dane które przyszły w z zapytaniu HTML tak klasa _ProductResponse_ przechowywuje obiety których wartości mają być wysłane w odpowiedzi naszej aplikacji, które Spring przepisze na odpowiedź HTML.



Domain

_Product_ - klasa której obiekty przechowują dane naszego produktu, tutaj _id_ i _name_.



Repository

_ProductRepository_ - interfejs dziedziczący po interfejsie _JpaRepository_. Obsjuguje operacje na naszej bazie danych. Interfejs _JpaRepository_ deklaruje zbiór metod jakie możemy wykonać na naszej bazie danych, ich instrukcje są przechowywane w dalszych klasach nadrzędnych.



Service

_ProductService_ - klasa ta realizuje instrukcje zapytania HTML, czyli odpowiada za zapisaywanie, wyszukiwanie i susuwanie danych w naszym serwisie, oraz przekazuje informacje zwrotne do poszczególnych części aplikacji.



Support

_ProductMapper_ - odpowiada za mapowanie - przepisywanie - obiektów pomiędzy _ProductService_ a resztą modłów aplikacji.

_ProductExceptionSupplier_ - zawiera metodę generującą obiekt błędu.

_ProductExceptionAdvisor_ - klasa która umożliwia nam obsłużenie wyjątku czyli przekazuje jego treść jako odpowiedź naszego serwisu wraz z odpowiednim błędem.

Exception

_ProductNotFoundException_ - deklaracja dodatkowego błędu aby poprawnie realizować błędne zapytania.

Shared.api.response

_ErrorMessageResponse_ - szablon do poprawnego przekazywania komunikatu błędu, do wielokrotnego wykorzystania w przypadku innych błędów.