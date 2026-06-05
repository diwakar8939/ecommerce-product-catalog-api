# 🛒 Ecommerce Product Catalog API

A RESTful API built with **Spring Boot** for managing products and reviews — with a simple frontend UI.

## 🛠️ Tech Stack
Java 17 · Spring Boot 3.2 · Spring Data JPA · H2 Database · Swagger · HTML/CSS/JS

## ✨ Features
- Full CRUD for Products (Create, Read, Update, Delete)
- Search by keyword, category, price range and rating
- Add reviews with average rating
- Input validation and global exception handling
- Swagger UI for API documentation
- Simple frontend to interact with the API



## 🌐 URLs

| Page | URL |
|---|---|
| Frontend | `http://localhost:8080` |
| Swagger UI | `http://localhost:8080/swagger-ui/index.html` |
| H2 Console | `http://localhost:8080/h2-console` |

## 📡 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| GET | `/api/products/search` | Search products |
| POST | `/api/products` | Create a product |
| PUT | `/api/products/{id}` | Update a product |
| DELETE | `/api/products/{id}` | Delete a product |
| POST | `/api/reviews` | Add a review |

## 👨‍💻 Author
**Diwakar S** · [LinkedIn](https://www.linkedin.com/in/diwakar-s-6654342b2/) · [GitHub](https://github.com/diwakar8939)
