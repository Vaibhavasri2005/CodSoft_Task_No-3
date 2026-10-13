# Student Grade Calculator & Performance Portal

A complete React + Spring Boot application for securely recording student marks, calculating grades on the server, and tracking performance over time.

## Features

- Student registration and login using roll number, date of birth, and BCrypt-hashed password
- JWT-protected dashboard, calculator, result history, and profile pages
- Dynamic subject inputs with client and server validation for marks from 0 to 100
- Backend-owned total, percentage, grade, performance, highest/lowest subject, and feedback calculation
- MySQL persistence with JPA relationships: one student has many results, each result has many subject marks
- Responsive academic dashboard UI with progress indicator and result insights

## Technology Stack

- Frontend: React, Vite, React Router, Axios, Lucide React
- Backend: Java 17, Spring Boot 3.3, Spring Web, Spring Data JPA/Hibernate, Spring Security, JWT, BCrypt
- Database: MySQL

## Architecture

`frontend/` contains the Vite React client. `backend/` contains the Maven Spring Boot REST API. The client sends a JWT bearer token for protected calls under `/api/students` and `/api/results`.

## Database Setup

Install MySQL and run:

```sql
CREATE DATABASE student_grade_db;
```

The application creates and updates tables with Hibernate (`spring.jpa.hibernate.ddl-auto=update`). Tables are `students`, `results`, and `subject_marks`.

## Backend Setup (Windows Command Prompt)

```cmd
cd backend
set DB_USERNAME=root
set DB_PASSWORD=your_mysql_password
set JWT_SECRET=replace-with-a-long-development-secret-key
mvnw.cmd spring-boot:run
```

If Maven Wrapper is not present, use `mvn spring-boot:run`. The API starts at `http://localhost:8080`.

You can also configure `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`, `JWT_SECRET`, and `JWT_EXPIRATION_MS` in the environment or `backend/src/main/resources/application.properties`.

## Frontend Setup (Windows Command Prompt)

```cmd
cd frontend
npm install
npm run dev
```

Open `http://localhost:5173`. To point to another API host, set `VITE_API_URL` before starting Vite.

## API Endpoints

| Method | Endpoint | Auth |
| --- | --- | --- |
| POST | `/api/auth/register` | No |
| POST | `/api/auth/login` | No |
| GET | `/api/students/profile` | JWT |
| POST | `/api/results/calculate` | JWT |
| GET | `/api/results` | JWT |
| GET | `/api/results/{id}` | JWT |
| DELETE | `/api/results/{id}` | JWT |

Example calculation request:

```json
{"subjects":[{"subjectName":"Java","marks":92},{"subjectName":"Database","marks":78}]}
```

## Flow

Register a student, sign in, open Grade Calculator, enter at least five subjects, calculate, and open Result History to review saved examinations. Logging out clears the browser token and protected routes redirect to login.

## Screenshots

Add project screenshots here after running the frontend locally.

## Future Enhancements

- Refresh-token rotation and email verification
- Exportable PDF result reports
- Faculty/admin analytics and class-level comparisons
- Editable profile and configurable grading schemes
