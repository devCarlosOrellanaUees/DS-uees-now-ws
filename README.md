# 🎓 Plataforma de Organización de Eventos Universitarios (Backend)

Este proyecto corresponde al backend de una plataforma diseñada para que organizaciones estudiantiles puedan publicar eventos, gestionar inscripciones, emitir certificados de participación y controlar aforos.

---

## 🏗️ Arquitectura

Este sistema utiliza una **arquitectura en capas (layered architecture)** compuesta por:

- **Capa de Presentación (Frontend)**: Next.js + React (no incluido en este repo)
- **API REST (ASP.NET Core)**: Exposición de servicios a través de controladores.
- **Lógica de Negocio (Services)**: Contiene reglas del dominio y procesos internos.
- **Persistencia (EF Core + PostgreSQL)**: Acceso a base de datos relacional.

Esta separación favorece la mantenibilidad, escalabilidad y claridad del código, ideal para equipos junior o educativos.

---

## 🧰 Tecnologías Utilizadas

- **Lenguaje:** C# (.NET 8 / ASP.NET Core Web API)
- **ORM:** Entity Framework Core (code-first)
- **Base de Datos:** PostgreSQL
- **JWT:** Autenticación segura con tokens
- **PDF:** Generación de certificados con PdfGenerator
- **Swagger:** Documentación automática de la API

---

## 📁 Estructura del Proyecto

```
PlataformaEventos_Backend/
│
├── Controllers/         # Endpoints de la API
├── Data/                # DbContext y Migrations
├── DTOs/                # Objetos de transferencia de datos
├── Models/              # Entidades del dominio
├── Services/            # Lógica de negocio
├── Utils/               # JWT, generación de PDFs, etc.
├── appsettings.json     # Configuración del proyecto
├── Program.cs           # Configuración inicial
├── Startup.cs           # Configuración de servicios y middlewares
└── README.md            # Documentación del proyecto
```

---

## 📌 Endpoints Clave

| Módulo          | Endpoint                                  | Método  |
|-----------------|--------------------------------------------|---------|
| Autenticación   | `/api/auth/register`                      | POST    |
|                 | `/api/auth/login`                         | POST    |
| Eventos         | `/api/eventos`                            | GET/POST/PUT |
| Inscripciones   | `/api/eventos/{id}/inscribir`             | POST    |
| Certificados    | `/api/certificados/generar`               | POST    |

---

## 🚀 Ejecución del proyecto

1. Configura tu conexión a PostgreSQL en `appsettings.json`.
2. Ejecuta las migraciones iniciales:
   ```bash
   dotnet ef migrations add InitialCreate
   dotnet ef database update
   ```
3. Ejecuta el proyecto:
   ```bash
   dotnet run
   ```

---

## 👨‍💻 Contribuciones

Este proyecto está orientado al aprendizaje, desarrollo colaborativo y mejora continua. Pull requests son bienvenidos.

---

## 📄 Licencia

Este proyecto está bajo licencia MIT. Puedes usarlo libremente para fines académicos o personales.

