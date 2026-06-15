# Sistema de Gestión de Productos - MiTienda

## Descripción

MiTienda es una aplicación de escritorio desarrollada en JavaFX que permite la gestión básica de productos mediante operaciones CRUD (Crear, Leer, Actualizar y Eliminar). El sistema incluye una pantalla de inicio de sesión y un dashboard administrativo con interfaz gráfica personalizada mediante CSS.

---

## Captura del Dashboard

<img width="1181" height="689" alt="dashboard" src="https://github.com/user-attachments/assets/dd89fa20-b5a8-4ca8-b9d6-402c70a34025" />


---

## Tecnologías Utilizadas

- Java 21
- JavaFX
- CSS
- Maven
- IntelliJ IDEA

---

## Funcionalidades Implementadas

### Inicio de Sesión

- Validación de usuario.
- Validación de contraseña.
- Selección de rol.
- Acceso al dashboard principal.

### Gestión de Productos

- Crear productos.
- Consultar productos.
- Actualizar productos.
- Eliminar productos.
- Limpiar formulario.
- Visualización de datos mediante TableView.

### Dashboard

- Menú lateral de navegación.
- Formulario de gestión de productos.
- Tabla de productos.
- Diseño personalizado con CSS.

---

## Estructura de Carpetas

```text
ProyectoJavaFX3
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.proyectojavafx3
│   │   │       ├── HelloApplication.java
│   │   │       ├── LoginController.java
│   │   │       ├── DashboardController.java
│   │   │       └── Producto.java
│   │   │
│   │   └── resources
│   │       └── com.example.proyectojavafx3
│   │           ├── login.fxml
│   │           ├── dashboard.fxml
│   │           ├── login.css
│   │           └── dashboard.css
│
├── pom.xml
└── README.md
```

---

## Instrucciones de Ejecución

### Requisitos

- Java JDK 21 o superior.
- Maven.
- IntelliJ IDEA.

### Pasos

1. Clonar el repositorio:

```bash
git clone (https://github.com/Briander-N/Tarea-Dise-o-POO.git)
```

2. Abrir el proyecto en IntelliJ IDEA.

3. Esperar la descarga de dependencias Maven.

4. Ejecutar la clase:

```text
HelloApplication.java
```

5. Iniciar sesión con:

```text
Usuario: admin
Contraseña: 1234
Rol: Administrador
```

---

## Autor

Nombre del estudiante: Briander Verdezoto
