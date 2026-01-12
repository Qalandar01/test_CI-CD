# ---------- BUILD STAGE ----------
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu AS build

WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# ---------- RUNTIME STAGE ----------
FROM mcr.microsoft.com/openjdk/jdk:17-ubuntu

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
