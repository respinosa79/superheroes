# Imagen Docker

Este módulo corresponde con todo lo relativo a la definición y generación de la imagen de Docker que contiene el artefacto desplegable  

### Generación del JAR del proyecto en la carpeta target

    mvn clean install

### Creación de la imagen 
 
 ```bash
$ docker build -t respinosa/heroes .
```

### Arrancar el contenedor

```bash
docker run -p 8080:8080 respinosa/heroes
```