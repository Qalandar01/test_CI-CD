# ---------- BUILD STAGE ----------
FROM mcr.microsoft.com/openjdk/jdk:17 AS build

WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# ---------- RUNTIME STAGE ----------
FROM mcr.microsoft.com/openjdk/jdk:17

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
