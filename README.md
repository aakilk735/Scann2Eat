# Scann2Eat – QR Based Food Ordering System

Scann2Eat is a simple Spring Boot project that allows users to view food products, generate QR codes, and create basic payment transactions. It is a backend-only project with clean REST APIs.

---

## 🚀 Features

- Add and list food products  
- Auto-load demo products when the app starts  
- Generate QR code for each product  
- Create and store payment transactions  
- Simple and clean API structure  
- Product images included inside the project

---

## 🛠 Tech Stack

- Java 17  
- Spring Boot  
- Maven  
- H2 / MySQL (configurable)  
- ZXing (for QR code generation)

---

## 📂 Project Structure

backend/
├── pom.xml # Maven configuration
├── .project / .classpath # IDE configuration (Eclipse)
├── .settings/ # Eclipse settings
│
├── src/
│ ├── main/
│ │ ├── java/com/example/qrpayment/
│ │ │ ├── QrPaymentApplication.java # Main Spring Boot class
│ │ │ ├── DataInitializer.java # Auto-load sample products
│ │ │ │
│ │ │ ├── controller/ # REST Controllers
│ │ │ │ ├── ProductController.java # Product APIs
│ │ │ │ └── PaymentController.java # Payment APIs
│ │ │ │
│ │ │ ├── service/ # Business logic layer
│ │ │ │ ├── ProductService.java # Product related logic
│ │ │ │ ├── PaymentService.java # Transaction logic
│ │ │ │ └── QRService.java # QR code generation
│ │ │ │
│ │ │ ├── repository/ # Database repositories
│ │ │ │ ├── ProductRepository.java # Product DB operations
│ │ │ │ └── TransactionRepository.java # Transaction DB operations
│ │ │ │
│ │ │ └── entity/ # Database entities
│ │ │ ├── Product.java # Product model
│ │ │ └── Transaction.java # Transaction model
│ │ │
│ │ ├── resources/
│ │ │ ├── application.properties # App configuration
│ │ │ │
│ │ │ ├── static/ # Frontend + Static Assets
│ │ │ │ ├── index.html # Main UI Page
│ │ │ │ ├── style.css # UI Styling
│ │ │ │ ├── script.js # API calls + JS logic
│ │ │ │ │
│ │ │ │ └── image/ # Product images
│ │ │ │ ├── burger.png
│ │ │ │ ├── cake.png
│ │ │ │ ├── coldrink.png
│ │ │ │ ├── donut.png
│ │ │ │ ├── fries.png
│ │ │ │ ├── hotdog.png
│ │ │ │ ├── momos.png
│ │ │ │ ├── noodles.png
│ │ │ │ ├── pizza.png
│ │ │ │ └── sandwich.png
│ │ │ │
│ │ │ └── templates/ (empty) # Optional Thymeleaf folder
│ │ │
│ │ └── index2.html # Extra UI page
│ │
│ └── test/ (optional test code)
│
└── target/ # Auto-generated build files
