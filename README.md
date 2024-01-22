# Employee Management System

## Overview

The Employee Management System is a Spring Boot project designed to manage employee information efficiently.

## Project Structure

The project follows a standard Spring Boot structure:


### Controller

Contains classes responsible for handling HTTP requests and managing the flow of the application.

#### Entity

Includes classes representing the data entities used in the system.

### Repository

Handles the data access and storage logic.

### Service

Implements business logic and interacts with the repository to perform CRUD operations.

### Exception

Handles custom exceptions for the application.

### Mapper

Converts entities to DTOs and vice versa.

### DTO

Data Transfer Objects used to transfer data between layers.

## Technologies Used

- Spring Boot
- Spring MVC
- Spring Data JPA
- MYSQL
- H2 Database (for development)

## How to Run

1. Clone the repository: `git clone https://github.com/dev-shahed/ems-backend.git`
2. Run the application: `./mvnw spring-boot:run`
3. Access the application at [http://localhost:8080](http://localhost:8080)

## Configuration

You can configure the application properties in the `application.properties` file.

## Contributing

Feel free to contribute by opening issues or submitting pull requests.

## License

This project is licensed under the [MIT License](LICENSE).