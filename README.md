# 🏦 Loan Management API

<p align="center">
  <img src="https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring_Boot-4.0.3-green?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/SQLite-3.45-blue?style=for-the-badge&logo=sqlite" />
  <img src="https://img.shields.io/badge/Maven-3.8+-red?style=for-the-badge&logo=apachemaven" />
  <img src="https://img.shields.io/badge/Status-Active-brightgreen?style=for-the-badge" />
</p>

A **Spring Boot REST API** for managing bank loan applications with role-based access control. This is the backend API version of the [Loan Management Desktop App](https://github.com/3mehmet3/loan-management-system).

---

## 🔗 API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/login` | User login |

### Loans
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/loans/apply` | Submit loan application |
| GET | `/api/loans/pending` | Get pending applications |
| GET | `/api/loans/all` | Get all applications |
| PUT | `/api/loans/{id}/approve` | Approve application |
| PUT | `/api/loans/{id}/reject` | Reject application |

### Users
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/users/add` | Add new user |
| GET | `/api/users/staff` | Get staff list |
| GET | `/api/users/managers` | Get managers list |

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 17+ | Core language |
| Spring Boot | 4.0.3 | REST API framework |
| Spring Data JPA | - | Database ORM |
| SQLite | 3.45 | Local database |
| Maven | 3.8+ | Dependency management |

---

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.8 or higher

### Run the application
```bash
# Clone the repository
git clone https://github.com/3mehmet3/loan-management-api.git
cd loan-management-api

# Build and run
mvn clean install
mvn spring-boot:run
```

API will be available at `http://localhost:8080`

---

## 📬 Example Requests

### Login
```json
POST /api/auth/login
{
    "username": "sema",
    "password": "2823"
}
```

### Submit Loan Application
```json
POST /api/loans/apply
{
    "firstName": "Ahmet",
    "lastName": "Yılmaz",
    "occupation": "Engineer",
    "annualIncome": "150000",
    "loanType": "HOUSING LOAN",
    "term": "24 months",
    "interestRate": "3.9%"
}
```

### Approve Loan
```
PUT /api/loans/1/approve
```

---

## 🏗️ Architecture
```
┌─────────────────────────────────────────┐
│           REST API Layer                │
│  AuthController, LoanController,        │
│  UserController                         │
├─────────────────────────────────────────┤
│           Service Layer                 │
│  UserService, LoanService               │
├─────────────────────────────────────────┤
│         Repository Layer                │
│  UserRepository, LoanRepository         │
├─────────────────────────────────────────┤
│           Data Layer                    │
│         SQLite (loan_management.db)     │
└─────────────────────────────────────────┘
```

---

## 🗺️ Roadmap

- [x] Role-based login system
- [x] Loan application submission
- [x] Approve/reject workflow
- [x] SQLite database integration
- [x] REST API with Spring Boot
- [ ] JWT Authentication
- [ ] Password encryption (BCrypt)
- [ ] Unit tests (JUnit 5)
- [ ] Docker support
- [ ] Swagger API documentation

---

## 🔗 Related Projects

- [Loan Management Desktop App](https://github.com/3mehmet3/loan-management-system) — Java Swing desktop version

---

## 👨‍💻 Author

**Mehmet Karakaş**
- GitHub: [@3mehmet3](https://github.com/3mehmet3)
- LinkedIn: [linkedin.com/in/mehmet-karakaş-a743b4267](https://www.linkedin.com/in/mehmet-karakaş-a743b4267/)

---

## 📄 License

This project is licensed under the MIT License.
