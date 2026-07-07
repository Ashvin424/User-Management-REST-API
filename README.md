# User Management REST API

A simple full CRUD REST API for managing users, built with **Spring Boot 3**, **Spring Data JPA**, and **MySQL**.

## Features

- Create, read, update, and delete users
- Request validation (name, email, age) using Jakarta Bean Validation
- Layered architecture: Controller → Service → Repository
- Auto-managed database schema via Hibernate (`ddl-auto=update`)

## Tech Stack

- Java 21
- Spring Boot 3.5.7
- Spring Data JPA (Hibernate)
- MySQL
- Maven

## Project Structure

```
src/main/java/com/example/crudapi
├── CrudApiApplication.java      # Application entry point
├── model/User.java              # User entity
├── repository/UserRepository.java  # JPA repository
├── service/UserService.java     # Business logic
└── controller/UserController.java  # REST endpoints
```

## Prerequisites

- Java 21+
- Maven (or use the included `mvnw` wrapper)
- MySQL running locally

## Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/User-Management-REST-API.git
   cd User-Management-REST-API
   ```

2. **Create the database**
   ```sql
   CREATE DATABASE crud_api;
   ```

3. **Configure database credentials**

   Edit `src/main/resources/application.properties` and set your MySQL username/password:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/crud_api?allowPublicKeyRetrieval=true&useSSL=false
   spring.datasource.username=root
   spring.datasource.password=YourDBPassword
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

   The API will start on `http://localhost:8080`.

## API Endpoints

Base path: `/api/users`

| Method | Endpoint          | Description         |
|--------|-------------------|----------------------|
| GET    | `/api/users`      | Get all users        |
| GET    | `/api/users/{id}` | Get a user by ID     |
| POST   | `/api/users`      | Create a new user     |
| PUT    | `/api/users/{id}` | Update an existing user |
| DELETE | `/api/users/{id}` | Delete a user by ID    |

### User Fields

| Field | Type   | Validation                          |
|-------|--------|--------------------------------------|
| id    | Long   | Auto-generated                       |
| name  | String | Required (not blank)                 |
| email | String | Required, must be a valid email      |
| age   | int    | Must be 18 or older                  |

### Example Requests

**Create a user**
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "age": 25
  }'
```

**Get all users**
```bash
curl http://localhost:8080/api/users
```

**Get a user by ID**
```bash
curl http://localhost:8080/api/users/1
```

**Update a user**
```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Updated",
    "email": "john.updated@example.com",
    "age": 26
  }'
```

**Delete a user**
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

## Notes

- On startup, Hibernate will automatically create/update the `user` table based on the `User` entity.
- Make sure MySQL is running before starting the app, otherwise the connection will fail.

## License

This project is open source and available for personal or educational use.
