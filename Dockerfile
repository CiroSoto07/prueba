# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim AS build

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR empaquetado a la imagen
COPY target/*.jar app.jar

# Exponer el puerto que tu aplicación va a utilizar (por defecto es el 8080 en Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]