# DB HOTEL
Este proyecto es una API RESTful desarrollada con **Java Spring Boot** para la gestión de reservas de habitaciones. Incluye funcionalidades para registrar usuarios, crear y consultar reservas, controlar el historial de cambios y calcular totales por reserva.

## 🧱 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- JUnit / Mockito
- Swagger (para documentación)

## 📊 Modelo de Datos

El sistema gestiona entidades como:
- **Users**: Usuarios registrados.
- **Rooms**: Habitaciones disponibles.
- **Reservations**: Reservas realizadas.
- **ReservationsHistorys**: Historial de cambios en reservas.
- **ReservationTotal**: Totales asociados a cada reserva.

![Modelo ER](./db.png)

## 🚀 Cómo ejecutar

```bash
# Clonar el repositorio
git clone https://github.com/usuario/rentapi.git
cd rentapi

# Compilar y correr la aplicación
./mvnw spring-boot:run