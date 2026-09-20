# 🚀 CampusLab Backend — Arquitectura de Microservicios
Este repositorio contiene la arquitectura backend del sistema CampusLab, diseñada mediante una arquitectura basada en microservicios y un patrón Backend for Frontend (BFF). El sistema facilita la gestión, reserva y reporte de uso de laboratorios y equipamiento institucion


## 🏗️ Arquitectura del Sistema
El backend está dividido en 4 servicios independientes construidos con Spring Boot 3 (Java 17) y desacoplados mediante contenedores Docker:

```campuslab-backend/
├── ms-campuslab-bff/          # (Puerto 8080) Gateway / BFF para la app Angular
├── ms-campuslab-bookings/     # (Puerto 8081) Microservicio de Gestión de Reservas
├── ms-campuslab-catalog/      # (Puerto 8082) Microservicio de Catálogo de Recursos
├── ms-campuslab-reports/      # (Puerto 8083) Microservicio de Módulo de Reportes
└── infra/                     # Orquestación de infraestructura
    └── compose.yml            # Docker Compose para levantar la suite completa
```

## 📦 Descripción de Componentes
1. ```ms-campuslab-bff``` (Puerto 8080): Actúa como puerta de entrada única para el cliente web (Angular). Se encarga del enrutamiento de peticiones mediante RestClient, validación de tokens OAuth2/JWT (Azure AD) y reexpresión de datos.
2. ```ms-campuslab-bookings``` (Puerto 8081): Encargado de la creación, consulta y actualización de estados de reservas de laboratorios y equipos.
3. ```ms-campuslab-catalog``` (Puerto 8082): Administra el catálogo de recursos disponibles (laboratorios, herramientas, equipos de medición).
4. ```ms-campuslab-reports``` (Puerto 8083): Procesa métricas de uso, tasa de ocupación y consolida información analítica para los administradores.  

## 🛠️ Requisitos Previos
Para ejecutar el backend de forma local o en un servidor (como AWS EC2), asegúrate de contar con:   
* Docker Desktop (o Docker Engine en Linux) v20.10+

* Docker Compose v2.0+

* Java 17 OpenJDK y Maven 3.8+ (Opcional, solo si deseas ejecutar los proyectos individualmente sin Docker).

## 🚦 Guía de Inicio Rápido (Con Docker Compose)
El método recomendado para levantar toda la solución es mediante Docker Compose:

### 1. Clonar el repositorio y entrar a la carpeta de infraestructura

```bash
git clone <URL_DEL_REPOSITORIO>
cd campuslab-backend/infra
```

### 2. Construir y levantar los contenedores
Ejecuta el siguiente comando para compilar las imágenes en paralelo y levantar los servicios en segundo plano:

```bash
docker compose up --build -d
```

### 3. Verificar que los servicios estén activos

```bash
docker compose ps
```

Deberías ver los 4 contenedores en estado ```Up / Running```:

* ```ms-campuslab-bff``` en ```http://localhost:8080```
* ```ms-campuslab-bookings``` en ```http://localhost:8081```
* ```ms-campuslab-catalog``` en ```http://localhost:8082```
* ```ms-campuslab-reports``` en ```http://localhost:8083```

### 4. Monitorear Logs
Si deseas ver la consola de auditoría de algún servicio en particular (ej. el BFF):

```bash
docker compose logs -f ms-campuslab-bff
```

## 🔗 Endpoints Principales (Consumo desde el Frontend)
Todas las peticiones desde el Frontend (Angular) deben ser dirigidas exclusivamente al BFF (http://```localhost:8080```):

| Servicio de Destino | Método | Endpoint en el BFF | Descripción |
| :----: | :---: | :-------: | :-------: |
| Catálogo | ```GET``` | ```/api/catalog/resources``` | Obtiene la lista completa de recursos |
| Catálogo | ```GET``` | ```/api/catalog/resources/{id}``` | Obtiene el detalle de un recurso específico |
| Reservas | ```GET``` | ```/api/bookings``` | Lista todas las reservas realizadas |
| Reservas | ```POST``` | ```/api/bookings``` | Crea una nueva solicitud de reserva |
| Reservas | ```PUT``` | ```/api/bookings/{id}/status``` | Actualiza el estado de una reserva |
| Reportes | ```GET``` | ```/api/report/summary``` | Obtiene métricas y porcentaje de ocupación |


## 🛑 Detener el Entorno
Para apagar y eliminar los contenedores e instancias de red creadas por Docker:

```bash
cd campuslab-backend/infra
docker compose down
```