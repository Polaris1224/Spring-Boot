# E-Commerce Application
This project is a Spring Boot-based E-Commerce Application designed with a microservices architecture to ensure modularity, scalability, and ease of maintenance. The application is divided into three core services, which communicate seamlessly using Eureka Server for service discovery and Feign Client for inter-service communication.

Key Features

User Authentication Service:
Handles user registration, login, and secure authentication using JWT (JSON Web Tokens).

Main Service:
Manages core functionalities, including product listings, order management, and cart operations.

Notification Service:
Sends notifications (e.g., order confirmation, updates) to users through various channels.

Technologies Used
Spring Boot: Backend framework for building the microservices.
Eureka Server: Service discovery for enabling communication between microservices.
Feign Client: Simplified RESTful API calls between services.
JWT: Secure user authentication and authorization.
MySQL: Database for storing application data.
Lombok: Simplified Java code by reducing boilerplate.

Project Structure
Copy code

├── User Authentication Service  
├── Main Service  
├── Notification Service  
└── Eureka Server  

How to Run the Application
Clone the repository.
Start the Eureka Server first to enable service discovery.
Run each service individually using your preferred IDE or mvn spring-boot:run.
Access the application endpoints through the respective service URLs.
Contributions

Contributions are welcome! Feel free to open issues or submit pull requests for enhancements or bug fixes.
