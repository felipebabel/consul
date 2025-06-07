# Consul

# Microservices with Consul Service Discovery, JWT Authentication and KV Configuration

As part of a college presentation where I had to explain how Consul works, I created a hands-on project to demonstrate its core functionalities in a real microservices environment.

This project demonstrates a microservices architecture using **HashiCorp Consul** for service discovery and KV configuration, along with **JWT-based authentication** and **basic round-robin load balancing** across service instances.

## 🧩 Architecture Overview

There are **three microservices** in this project:

### 📦 Service 1 (`service-a`)
- Entry point for requests.
- Reads `audience` value from **Consul KV store**.
- Sends a request with a **JWT** and the audience (from KV) to **Service 3**.
- Forwards the result to **Service 2** using Consul service name instead of hardcoded IP/port.
- Allows observing **round-robin load balancing** when multiple Service 2 instances are registered in Consul.

### 📦 Service 2 (`service-b`)
- Registered in Consul with two running instances.
- Receives requests from Service 1.
- Helps demonstrate **load balancing** through Consul DNS-based or HTTP API-based resolution.

### 📦 Service 3 (`service-c`)
- Reads expected `audience` from Consul KV store.
- Exposes an endpoint that:
    - **Validates incoming JWT** (including audience claim).
    - Returns a value (e.g., a timestamp or random string).
- Acts as a backend protected service.

---

## 🧪 Key Features

- ✅ **Consul Service Discovery**: Service 1 locates Service 2 via service name, not IP.
- ✅ **Consul KV**: Central config (e.g., JWT audience) fetched dynamically.
- ✅ **JWT Authentication**: Service 3 validates JWT sent by Service 1.
- ✅ **Load Balancing**: Service 2 runs multiple instances, balancing via Consul.
- ✅ **Secure Communication**: Service-to-service communication includes JWT for secure access.

---

## ⚙️ Technologies

- Java 17 (Spring Boot)
- Consul Agent (Local/Dev mode)
- JWT (e.g., using `jjwt` or Spring Security)
- Docker & Docker Compose (optional)

---

## 🚀 Getting Started

### Prerequisites

- Docker and Docker Compose (recommended)
- Java 17+ and Maven

### Clone the repo

```bash
git clone git@github.com:felipebabel/consul.git
```

### Requests

```bash
curl --location --request PUT 'http://localhost:8500/v1/kv/config/springbootconsul/data' \
--header 'Content-Type: text/plain' \
--data 'audience: service-1'
```

```bash
curl --location 'localhost:8081/call-service-tree'
```

```bash
curl --location 'localhost:8081/call-service-two'
```

```bash
curl --location 'localhost:8084/config/consul-value'
```
```bash
curl --location --request PUT 'http://localhost:8500/v1/kv/config/springbootconsul/data' \
--header 'Content-Type: text/plain' \
--data 'message: service-2'
```
