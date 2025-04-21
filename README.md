# 🧑‍💼 Employee Management System

The **Employee Management System** is a simple system that allows users to manage departments and employees within an organization. Each employee is assigned to a specific department, and departments can have multiple employees.


[Screencast from 03-26-2024 08:27:26 PM.webm](https://github.com/dev-shahed/ems-frontend/assets/125728402/9e94e4c1-bfc9-4ca0-9b6c-1086f0e6bc99)

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


---

## ✨ Features

- Add new Departments through the **Add Department** section
- Add new Employees through the **Add Employee** section
- Each employee must be assigned to one department
- View the system structure via a clear ER diagram

---

## 🗺️ System Diagram

![image](https://github.com/user-attachments/assets/36403cb0-81c8-45f8-8d10-60bae30dd7f1)

## License

This project is licensed under the [MIT License](LICENSE).
