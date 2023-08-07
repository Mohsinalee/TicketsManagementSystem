FROM openjdk:17
WORKDIR /app
COPY target/ticket-management.jar ticket-management.jar
EXPOSE 8080
CMD ["java", "-jar", "ticket-management.jar"]