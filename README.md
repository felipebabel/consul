# Consul

# Microservices with Consul Service Discovery, JWT Authentication and KV Configuration

As part of a college presentation where I had to explain how Consul works, I created a hands-on project to demonstrate its core functionalities in a real microservices environment.

This project demonstrates a microservices architecture using **HashiCorp Consul** for service discovery and KV configuration, along with **JWT-based authentication** and **basic round-robin load balancing** across service instances.

## 🧩 Architecture Overview

There are **three microservices** in this project:

### 📦 Service 1
- Entry point for requests.
- Reads `audience` value from **Consul KV store**.
- Sends a request with a **JWT** and the audience (from KV) to **Service 3**.
- Forwards the result to **Service 2** and **Service 3** using Consul service name instead of hardcoded IP/port.
- Allows observing **round-robin load balancing** when multiple Service 2 instances are registered in Consul.

### 📦 Service 2
- Registered in Consul with two running instances.
- Receives requests from Service 1.
- Helps demonstrate **load balancing** through Consul.
- Exposes an endpoint that:
  - Returns the container ID value.

### 📦 Service 3
- Reads expected `audience` from Consul KV store.
- Exposes an endpoint that:
    - **Validates incoming JWT** (including audience claim).
    - Returns the container ID value.
---

##  Key Features

- ✅ Service Discovery with Consul
- ✅ Centralized Configuration with Consul KV
- ✅ JWT-Based Secure Communication
- ✅ Round-Robin Load Balancing with Multiple Instances
- ✅ Spring Boot Actuator for Health Monitoring
---

## 💻 Tech Stack

- Java 17 (Spring Boot)
- Consul Agent 
- JWT 
- Docker & Docker Compose

---

## 🚀 Getting Started

### Prerequisites

- Docker and Docker Compose
- Java 17+
- Maven
---
### Clone the repo

```bash
git clone git@github.com:felipebabel/consul.git
```
---
## 📋 Testing the System

### ⚙️ Set the audience Value in Consul KV

You can use this cURL command or set the key manually via the Consul UI:

```bash
curl --location --request PUT 'http://localhost:8500/v1/kv/config/springbootconsul/data' \
--header 'Content-Type: text/plain' \
--data 'audience: service-2'
```
### 📂 Make Sample Requests

Call Service 3 via Service 1 (JWT + Audience from KV):
```bash
curl --location 'localhost:8081/call-service-tree'
```
Call Service 2 via Service 1 (Load Balanced):

```bash
curl --location 'localhost:8081/call-service-two'
```
---
## ❤️ Health Check Endpoints
Service 1
```bash
curl --location 'http://localhost:8081/actuator/health'
```
Service 2 Instance 1
```bash
curl --location 'http://localhost:8082/actuator/health'
```
Service 2 Instance 2

```bash
curl --location 'http://localhost:8083/actuator/health'
```
Service 3

```bash
curl --location 'http://localhost:8084/actuator/health'
```
