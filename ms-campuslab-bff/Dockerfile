# Stage 1: Build de la aplicación con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copiar configuración de Maven y descargar dependencias (Cache Layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente y compilar el JAR omitiendo tests
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Imagen de ejecución ligera (JRE)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Crear usuario no-root por seguridad
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiar el ejecutable generado desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Puerto expuesto dinámicamente según la app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]