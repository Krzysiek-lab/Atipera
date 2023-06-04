Jest to aplikacja pozwalająca na pozyskanie listy wszystkich (również prywatnych) repozytoriów na github'ie użytkownika o podanej nazwie w polu "userName". 
Dodatkowym polem jest pole "header", które ma domyślną wartość "Accept: application/json". Aplikacja ma jeden endpoint dostępny pod adresem http://localhost:8080/git/?userName=<nazwa_użytkownika>&header=Accept%3A%20application%2Fjson.
Ponadto dla lepszego testowania ten sam endpoint jest wystawiony na swaggerze pod adresem http://localhost:8080/swagger-ui/index.html#/

Aby móc pozyskać również prywatne repozytoria należy po zalogowaniu na konto github wygenerować token, który nastepnie należy wkleić do metody getStringBuilder() interfejsu GitService jako parametr metody urlConnection.setRequestProperty("Authorization", "Bearer " + "tu token").
Metoda ta domyslnie bedzie zakomentowana dojąc dostęp tylko do publicznych repozytoriów, należy ją odkomentować, dodać token i uruchomić apilkację ponownie.
