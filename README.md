# Spring-H2

`On Development Progress ... `

## Description
This project is a simple Spring Boot application that uses H2 in-memory database. It is a simple REST API that allows to create, read, update and delete users.

## Requirements
- Java 17 or higher
- Maven 3.8.3 or higher
- Postman 9.0.5 or higher
- IntelliJ IDEA 2021.2.2 or higher
- Git 2.33.0 or higher
- GitHub CLI 2.2.0 or higher
- GitHub account

## Installation
1. Clone the repository using the command `git clone https://github.com/ivandi1980/spring-h2.git`.
2. Open the project in IntelliJ IDEA.
3. Run the project using the command `mvn spring-boot:run`.
4. Open Postman and test the API.
5. Stop the project using the command `Ctrl + C`.

## Usage
1. Open Postman.
2. Create a new request.
3. Set the request type to `GET`.
4. Set the request URL to `http://localhost:8080/api/v1/users`.
5. Click on the `Send` button.
6. Create a new request.
7. Set the request type to `POST`.
8. Set the request URL to `http://localhost:8080/api/v1/users`.
9. Set the request body to `{"name": "John Doe", "email": "bQpC3@example.com"}`.
10. Click on the `Send` button.
11. Create a new request.
12. Set the request type to `GET`.
13. Set the request URL to `http://localhost:8080/api/v1/users/1`.
14. Click on the `Send` button.
15. Create a new request.
16. Set the request type to `PUT`.
17. Set the request URL to `http://localhost:8080/api/v1/users/1`.
18. Set the request body to `{"name": "Jane Doe", "email": "bQpC3@example.com"}`.
19. Click on the `Send` button.
20. Create a new request.
21. Set the request type to `DELETE`.
22. Set the request URL to `http://localhost:8080/api/v1/users/1`.
23. Click on the `Send` button.
24. Stop the project using the command `Ctrl + C`.
25. Close Postman.

## Support
If you have any questions or need help, please send an email to [ivandjoh](mailto:ivandi.djoh@gmail.com)