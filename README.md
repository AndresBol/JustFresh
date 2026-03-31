<p align="center">
  <img src="src/media/Banner.png" alt="Just Fresh! Banner" width="600"/>
</p>

<h1 align="center">Just Fresh!</h1>

<p align="center">
  A desktop food ordering and restaurant management system built with Java Swing and SQL Server.
  <br/>
  <strong>Programming II Final Project</strong> - Universidad Técnica Nacional (UTN)
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-SE%208+-orange?logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/SQL%20Server-2022-blue?logo=microsoftsqlserver&logoColor=white" alt="SQL Server"/>
  <img src="https://img.shields.io/badge/IDE-NetBeans-green?logo=apachenetbeans&logoColor=white" alt="NetBeans"/>
  <img src="https://img.shields.io/badge/UI-Java%20Swing-yellow" alt="Swing"/>
</p>

---

## About

Just Fresh! is a full-stack desktop application that simulates a food delivery platform where users can browse restaurants, add products to a shopping cart, place orders, and leave reviews. It supports three user roles with different permission levels and includes a complete CRUD management module and reporting dashboards.

This project was developed as the final assignment for the Programming II course, demonstrating skills in object-oriented programming, relational database design, layered architecture, and GUI development.

## Features

- **User authentication**: Login and registration with role-based access control
- **Three user roles:**
  - **Regular**: Browse restaurants, place orders, leave reviews
  - **Manager**: Manage own restaurants and product catalogs
  - **Administrator**: Full system access, user management, and reporting
- **Restaurant & product catalog**: Browse by type, filter, and search
- **Shopping cart & checkout**: Add products, review cart, and complete purchases with credit card
- **Order tracking**: View completed orders and purchase history
- **Review system**: Star-based ratings for restaurants
- **CRUD maintenance modules**: Manage countries, users, products, and restaurants
- **Reports dashboard:**
  - Purchases made
  - Best-rated restaurants
  - Product statistics

## Tech Stack

| Layer       | Technology                           |
| ----------- | ------------------------------------ |
| Language    | Java SE 8+                           |
| GUI         | Java Swing (JFrame, JDialog, JPanel) |
| Database    | Microsoft SQL Server 2022            |
| JDBC Driver | sqljdbc41                            |
| Build Tool  | Apache Ant (NetBeans)                |
| IDE         | NetBeans                             |

## Architecture

The project follows a layered architecture pattern:

```
src/
├── entidades/           # Domain model: entities, enums, and inheritance hierarchy
├── PersistenciaDAO/     # Data Access Objects: JDBC-based CRUD operations
├── justFresh/           # Presentation layer: Swing forms, dialogs, and panels
├── utilitarios/         # Shared utility classes
├── librerias/           # External libraries (JDBC driver, JAXB)
└── media/               # UI assets: icons, banners, logos
```

Entity hierarchy uses OOP inheritance:

- `Usuario` (abstract) -> `UsuarioRegular`, `UsuarioGerente`, `UsuarioAdministrador`
- `Producto` -> `ProductoEmpacado`, `ProductoPreparado`

## Database Schema

The SQL Server database consists of 10 tables:

`Usuario` - `Pais` - `Permiso` - `UsuarioPermiso` - `Restaurante` - `Producto` - `Resena` - `Tarjeta` - `OrdenCompra` - `LineaCompra`

The full creation script is available in [`MSQLS_DBQuery.sql`](MSQLS_DBQuery.sql).

## Prerequisites

- Java JDK 8 or higher
- Microsoft SQL Server (2016+)
- NetBeans IDE

## Getting Started

1. **Clone the repository**

   ```bash
   git clone https://github.com/AndresBol/JustFresh.git
   ```

2. **Set up the database**
   - Open SQL Server Management Studio
   - Execute the script [`MSQLS_DBQuery.sql`](MSQLS_DBQuery.sql) to create the database and tables

3. **Configure the connection**
   - Update credentials in `src/PersistenciaDAO/ConexionSqlServer.java` if needed:
     ```java
     public static final String USER = "sa";
     public static final String PASSWORD = "your_password";
     ```

4. **Open and run**
   - Open the project in NetBeans
   - Build and run, the entry point is `justFresh.principal`

## Login Credentials

| Role          | Email                     | Password     |
| ------------- | ------------------------- | ------------ |
| Administrator | `admin@justfresh.com`     | `Admin123`   |
| Manager       | `gerente1@justfresh.com`  | `Gerente123` |
| Regular User  | `andres.lopez@correo.com` | `Andres567`  |

## Author

**Andrés Bolaños** - Student ID: 119090051

Universidad Técnica Nacional (UTN)

---

<p align="center">
  <sub>Built with Java Swing as an academic project - 2024</sub>
</p>
