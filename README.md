# Data Entry Application with Database Connectivity

## Project Overview

A Java web application developed as a mini project for database application development. It allows users to select a customer from a database-driven dropdown, enter transaction details, save transactions to MySQL, and view saved records in a report.

## Features

- Dynamically loads customer information from MySQL.
- Accepts customer, transaction amount, and transaction date.
- Saves transactions using JDBC and `PreparedStatement`.
- Validates form inputs on the client and server sides.
- Enforces database relationships using primary and foreign keys.
- Generates a transaction report using an SQL `INNER JOIN`.
- Displays success and error messages.

## Technologies Used

- Java
- JSP (JavaServer Pages)
- Java Servlets
- JDBC
- MySQL
- Apache Tomcat 9
- JSTL 1.2
- HTML and CSS
- Eclipse IDE

## Application Architecture

- **Model:** Represents customer and transaction data.
- **DAO:** Performs database operations using JDBC.
- **Servlets:** Handle HTTP requests, validation, and application flow.
- **JSP:** Displays the transaction form and report.
- **MySQL:** Stores customer master data and transaction records.

## Database Structure

### customers

Stores customer master data, including customer ID, customer name, and phone number.

### transactions

Stores transaction ID, customer ID, transaction amount, and transaction date.

- `transaction_id` is the primary key.
- `customer_id` is a foreign key referencing `customers.customer_id`.
- One customer can have multiple transactions.

## Application Workflow

1. The transaction page requests customer details from the database.
2. The user selects a customer and enters the transaction amount and date.
3. The Servlet validates the submitted values.
4. The DAO inserts the transaction into MySQL using a `PreparedStatement`.
5. The application redirects to the form and displays a success or error message.
6. The report Servlet retrieves transaction records using an `INNER JOIN`.
7. The report JSP displays the saved transactions with customer details.

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK)
- Eclipse IDE
- Apache Tomcat 9
- MySQL Server
- MySQL Connector/J
- JSTL 1.2

### Database Setup

1. Open MySQL Workbench.
2. Open and execute the provided `database.sql` file.
3. Confirm that the `mini_project_1` database and its required tables exist.

### Database Configuration

The database connection is configured in `util.DBConnection`.

For security, database credentials should not be hard-coded or committed to a public repository.

Configure the following environment variables on your computer:

- `DB_URL` — `jdbc:mysql://localhost:3306/mini_project_1`
- `DB_USER` — your MySQL username
- `DB_PASSWORD` — your MySQL password

Update `DBConnection.java` to read these environment variables, for example:

```java
private static final String URL = System.getenv("DB_URL");
private static final String USER = System.getenv("DB_USER");
private static final String PASSWORD = System.getenv("DB_PASSWORD");
```

Ensure that the connection code uses these values and that all three variables are configured before running the application.

### Run the Application

1. Import the project into Eclipse.
2. Configure Apache Tomcat 9.
3. Ensure the required libraries are available under `WEB-INF/lib`.
4. Start MySQL and Tomcat.
5. Open the transaction form:

   `http://localhost:8080/DataEntryApplication/transaction`

6. Open the transaction report:

   `http://localhost:8080/DataEntryApplication/report`

## Testing

The application was tested for customer dropdown loading, transaction insertion, success messages, report generation, navigation, form clearing, and browser-side validation. The database foreign key was also verified to reject transactions referencing nonexistent customers.

## Project Files

- `README.md` — project documentation.
- `database.sql` — database schema and optional sample data.
- Java source files — application logic.
- JSP files — transaction form and report interface.
- `WEB-INF/lib` — required JDBC and JSTL libraries.

## Security Notes

- Never commit real database credentials to a public repository.
- Configure database credentials using environment variables.
- Do not include passwords in screenshots, documentation, or source control.
- Use a database account with only the permissions required by the application.

## Purpose

This project demonstrates Java web development, database connectivity using JDBC, CRUD-related database operations, relational database design, server-side validation, and SQL reporting.