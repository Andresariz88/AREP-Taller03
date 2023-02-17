# Microframeworks WEB

Servidor web que soporta una funcionalidad similar a la de Spark. La aplicación permite el registro de servicios get y post usando funciones lambda, configurar el directorio de los archivos estáticos, y cambiar el tipo de la respuesta del encabezado Http. Construido únicamente con el API básico de Java. No utiliza frameworks como Spark o Spring.

Adicionalmente, contiene una aplicación web que permite consultar la información de películas y series ingresadas por el usuario. Consta de un input text y un botón el cual hace la solicitud al servidor, de la película o serie ingresada, y este devuelve la información en formato JSON. El servidor consta de un caché tolerante a concurrencia y un servicio de conexión al API externo de [OMDb](https://omdbapi.com/) de donde obtendrá la información requerida.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them
Para hacer uso de la aplicación necesitarás tener instalado el siguiente software
- [JDK](https://www.oracle.com/co/java/technologies/javase/javase8-archive-downloads.html) version 1.8.x
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)


### Installing

Para obtener una copia de la aplicación deberás clonar este repositorio. Ingresa la siguiente instrucción en Git Bash:

```
git clone https://github.com/Andresariz88/AREP-Taller01
```

Luego, ejecuta el siguiente comando para compilar y empaquetar todo el proyecto:

```
mvn package
```

Para iniciar el servidor web basta con ejecutar el main de la clase HttpServer o ingresar el siguiente comando en el terminal:
```
mvn exec:java
```

Para usarlo simplemente ingresa la siguiente URL en la barra de búsqueda de tu navegador web:
```
127.0.0.1:35000
```

Y listo, la aplicación estará lista para que la uses.

![](./img/img0.png)
![](./img/img1.png)

## Running the tests

Para correr los test automatizados usa el comando:
```
mvn test
```
También, la clase **JavaClient** establece una conexión con el servidor sin necesidad de usar un navegador web. Puedes probar el servicio enviando múltiples instrucciones por medio de la consola y ver cómo el servidor las maneja. El archivo [post-request.txt](./post_requests.txt) contiene varias líneas de peticiones que puedes copiar y pegar.

## Diseño
El proyecto cuenta con una clase llamada **HttpServer** la cual hace de fachada de servidor web y expone el servicio para ser consumido por un cliente. A su vez, esta clase cuenta con los mecanismos necesarios para manejar las diferentes solicitudes hechas por los clientes y un caché tolerante a concurrencia en el cual se guardarán todas las peticiones hechas al API externo, para que la próxima vez que se soliciten el tiempo y consumo de recursos sea mínimo.

### Microframeworks WEB

Anteriormente, se tenían una interfaz de servicios **REST** y múltiples clases que manejaban las diferentes solicitudes para los recursos HTML, CSS, JavaScript e img de la página.

Estos servicios se suprimieron y ahora simplemente se tiene una clase (**StaticFiles**) que maneja las solicitudes y busca los archivos estáticos en el disco del servidor, y otra (**HttpResponse**) que configura el encabezado y el cuerpo del paquete Http que se va a enviar.

Adicionalmente, se agregó la posibilidad de configurar servicios web de tipo GET y POST manualmente por medio de **funciones lambda**.

## Ejemplo de desarrollo de aplicaciones en el servidor + prueba en Windows

El servidor web funciona bajo el Patrón de Diseño Singleton, así que podremos acceder a él sin necesidad de crear una instancia del mismo.

    HttpServer server = HttpServer.getInstance();

1. **Static Files**

Para configurar el directorio estático de archivos basta con indicarle una ruta de la siguiente manera:

    // La raíz es "src/main/resources", así que en este caso quedaría en "src/main/resources/public"
    server.staticFiles.location("/public");

En esta carpeta se encuentra nuestra página de Error 404 así que intentaremos acceder a ella

![](./img/img2.png)

2. **GET**

Para configurar servicios GET podemos hacerlo de la siguiente manera:

    server.get("/hello", (req, res) -> "Hello World");

En este caso, creamos el recurso "/hello" que nos devolverá "Hello World" al consultarlo por medio del método GET

![](./img/img3.png)

También podemos cambiar el tipo de respuesta del encabezado Http

    server.get("/get-json", (req, res) -> {
        res.type("application/json");
        return "{\"name\": \"Daniel\"}";
    });

Aquí, configuramos el tipo del recurso "/get-json" para que nos retorne un JSON

![](./img/img4.png)

3. **POST**

Para configurar servicios POST podemos hacerlo de la siguiente manera:

    server.post("/json-post", (req, res) -> {
        res.type("application/json");
        return "{\"name\": \"Daniel\"}";
    });

Para probarlo, creamos un archivo HTML en la carpeta public el cual tiene un script que pide por POST el recurso que acabamos de configurar

    let url = "/json-post";
    fetch (url, {method: 'POST'})
        .then(response => response.json())
        .then(data => {
            console.log(data);
    });

Al recibirlo, el recurso se imprimirá en la consola del navegador

![](./img/img5.png)

## Prueba Linux

Las pruebas se realizaron en una máquina Kali Linux. El proyecto se ejecutó haciendo uso del comando:

    java -cp target/classes org.arep.webapps.WebApp

![](./img/img6.png)

GET
![](./img/img7.png)

GET Content-type: application/json
![](./img/img8.png)

POST
![](./img/img9.png)

Static Files
![](./img/img10.png)

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Authors

* **Andrés Ariza** - *Initial work* - [Andresariz88](https://github.com/Andresariz88)


