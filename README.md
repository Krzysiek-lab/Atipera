Jest to aplikacja pozwaljąca na pozyskanie listy wszytkich (również prywatnych) repozytoriów na github'ie użytkownika o podanej nazwie w polu "userName". 
Dodatkowym polem jest pole "header", które ma domyślną wartość "Accept: application/json". Aplikacja ma jeden endpoint GET dostępny pod adresem http://localhost:8080/git/?userName=<nazwa użytkownika>&header=Accept%3A%20application%2Fjson.
Ponadto dla lepszego testowania ten sam endpoit jest wystawipny na swaggerze pod adresem http://localhost:8080/swagger-ui/index.html#/
