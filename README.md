# dockerized-springboot-postgres
Dockerized REST API with Database

# User Service

`user-service` is a simple Spring Boot application that exposes REST APIs to manage users.  
It uses **PostgreSQL** as the database and is fully **Dockerized** for easy local setup.

---

## 🚀 Features

- Create a user
- Fetch a user by ID
- PostgreSQL as the database
- Dockerfile to build the application image
- docker-compose to run the app and database together

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle
- Docker & Docker Compose

---

## 📌 API Endpoints

### 1️⃣ Create User

**POST** `/api/v1/user`

**Request Body**
```json
{
  "firstName": "Sushant",
  "lastName": "Madke",
  "addressRequestList": [
    {
      "addressType": "HOME",
      "houseNumber": "12",
      "street": "Sheetal Baug",
      "city": "Pune",
      "state": "Maharashtra",
      "zipCode": "411309"
    }
  ]
}


