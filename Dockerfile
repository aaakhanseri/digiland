# Используем официальный образ Java
FROM eclipse-temurin:17-jdk-jammy

# Рабочая директория
WORKDIR /app

# Копируем собранный JAR-файл
COPY target/your-application.jar app.jar

# Открываем порт
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]