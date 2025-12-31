[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/h7cAiAf6)
# Lab: Spring Core Fundamentals - Library System Foundation

## Goal
Create the foundation of a Library Management System using Spring Boot with proper dependency injection patterns.

## Learning Objectives
- Set up a Spring Boot project with required dependencies
- Create JPA entities with proper annotations
- Implement repository interfaces using Spring Data JPA
- Apply constructor-based dependency injection
- Seed initial data using CommandLineRunner

## Pre-requisites
- Java 17+ installed
- IDE with Spring support (IntelliJ, VS Code, Eclipse)
- Maven knowledge
- Understanding of OOP concepts

## Tasks

### Task 1: Create Spring Boot Project
Go to [Spring Initializr](https://start.spring.io) and configure:

| Setting | Value |
|---------|-------|
| Project | Maven |
| Language | Java |
| Spring Boot | 3.x (latest) |
| Group | com.revature |
| Artifact | library |
| Packaging | Jar |
| Java | 17 or 21 |

**Dependencies to add:**
- Spring Web
- Spring Data JPA
- H2 Database
- Spring Boot DevTools

### Task 2: Create the Book Entity
Create `Book.java` in `src/main/java/com/revature/library/model/`:

**Required Fields:**
- `id`: Long (auto-generated primary key)
- `title`: String (required)
- `author`: String (required)
- `isbn`: String (unique)
- `available`: boolean (default: true)

**Starter code provided**: See `starter_code/Book.java`

### Task 3: Create the Repository
Create `BookRepository.java` interface in `repository/` package:
- Extend `JpaRepository<Book, Long>`
- Add custom query: `findByAuthorContaining(String author)`

### Task 4: Create the Service Layer
Create `BookService.java` in `service/` package using **constructor injection**:

**Methods to implement:**
- `getAllBooks()`: List<Book>
- `findById(Long id)`: Optional<Book>
- `addBook(Book book)`: Book
- `checkoutBook(Long bookId)`: Book
- `returnBook(Long bookId)`: Book

**Starter code provided**: See `starter_code/BookService.java`

### Task 5: Seed Sample Data
Create `DataSeeder.java` configuration class to populate 5 books on startup.

**Books to add:**
1. "Clean Code" by Robert Martin
2. "The Pragmatic Programmer" by David Thomas
3. "Design Patterns" by Gang of Four
4. "Effective Java" by Joshua Bloch
5. "Spring in Action" by Craig Walls

## Deliverables
1. Working Spring Boot project
2. Book entity with proper JPA annotations
3. BookRepository interface
4. BookService with constructor injection
5. DataSeeder that populates initial books

## Verification
- [ ] Application starts without errors
- [ ] H2 console accessible at `http://localhost:8080/h2-console`
- [ ] BOOKS table exists with 5 records
- [ ] BookService uses constructor injection

## Starter Code
See `starter_code/` directory
