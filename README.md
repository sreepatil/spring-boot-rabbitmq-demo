# Spring Boot RabbitMQ Demo

A hands-on Spring Boot application demonstrating asynchronous messaging using **RabbitMQ** and **Spring AMQP**. This project covers String and JSON message publishing and consumption, providing practical experience with message queues and asynchronous communication.

## 🚀 Features

- RabbitMQ integration with Spring Boot
- String message publishing using RabbitTemplate
- String message consumption using @RabbitListener
- JSON message publishing and consumption
- Object serialization and deserialization
- Queue, Exchange, and Binding configuration
- Topic Exchange with Routing Keys
- RabbitMQ setup using Docker
- REST APIs for message publishing

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Programming Language |
| Spring Boot | Application Framework |
| Spring AMQP | RabbitMQ Integration |
| RabbitMQ | Message Broker |
| Docker | Containerization |
| Maven | Dependency Management |
| Lombok | Boilerplate Code Reduction |
| REST API | Message Publishing |

## 🏗️ Project Architecture

```text
                 Client
                   |
                   v
             REST Controller
                   |
                   v
             RabbitMQ Producer
                   |
                   v
             RabbitMQ Exchange
                   |
             Routing Key
                   |
                   v
              RabbitMQ Queue
                   |
                   v
             RabbitMQ Consumer
                   |
                   v
             Message Processing
```

## ⚙️ Prerequisites

Make sure you have installed:

- Java JDK
- Maven
- Docker Desktop
- Git
- IDE (IntelliJ IDEA / Eclipse / VS Code)

## 🐳 Running RabbitMQ with Docker

Start RabbitMQ using the management image:

```bash
docker run -d --rm \
  --name rabbitmq \
  -p 5672:5672 \
  -p 15672:15672 \
  rabbitmq:4-management
```

Verify the running container:

```bash
docker ps
```

## 🖥️ RabbitMQ Management Dashboard

Access the RabbitMQ management dashboard:

http://localhost:15672

Default local credentials:

| Property | Value |
|---|---|
| Username | guest |
| Password | guest |
| AMQP Port | 5672 |
| Management Port | 15672 |

```

## ▶️ Run the Application

Clone the repository:

```bash
git clone https://github.com/sreepatil/spring-boot-rabbitmq-demo.git
```

Navigate to the project directory:

```bash
cd spring-boot-rabbitmq-demo
```

Build the project:

```bash
mvn clean install
```

Run the Spring Boot application:

```bash
mvn spring-boot:run
```

The application will start at:

http://localhost:8080

## 📩 String Message Messaging

The application supports publishing and consuming simple String messages through RabbitMQ.

Example request:

```http
GET http://localhost:8080/publish?message=hello%20world
```

Expected response:

```text
Message sent to RabbitMQ
```

The RabbitMQ Consumer receives and processes the published String message.

## 📦 JSON Message Messaging

The application also supports publishing and consuming structured JSON messages.

Example JSON payload:

```json
{
  "id": 1,
  "firstName": "Shubham"
  "lastName": "Patil"
}
```

The JSON message is serialized before publishing and deserialized by the consumer for processing.

Use the JSON publishing endpoint implemented in the application.

## 🔄 Message Flow

1. Client sends a request to the Spring Boot REST API.
2. Controller receives the message.
3. Producer publishes the message using RabbitTemplate.
4. RabbitMQ Exchange receives the message.
5. Routing Key determines the destination queue.
6. RabbitMQ Queue stores the message.
7. Consumer receives the message using @RabbitListener.
8. Consumer processes the received message.

## 📚 Key Concepts Covered

- Message Broker
- Asynchronous Communication
- Producer and Consumer Pattern
- Queue and Exchange
- Topic Exchange
- Routing Keys
- Message Serialization
- JSON Deserialization
- Spring AMQP
- RabbitMQ Integration

## 👨‍💻 Author

**Shubham Patil**

Java Backend Developer
