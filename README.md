# 🧮 Calculator API Demo

A Spring Boot REST API that provides calculator functionality with a beautiful web interface for testing.

## ✨ Features

- **Mathematical Operations**: Addition, Subtraction, Multiplication, Division, Power, and Modulo
- **RESTful API**: Clean REST endpoints with proper HTTP status codes
- **Input Validation**: Comprehensive validation with meaningful error messages
- **Error Handling**: Proper exception handling and user-friendly error responses
- **Web Interface**: Beautiful HTML interface for testing the API
- **Cross-Origin Support**: CORS enabled for frontend integration

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. **Clone/Download the project**
2. **Navigate to project directory**
   ```bash
   cd calculator-Demo
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - Web Interface: http://localhost:8080
   - API Base URL: http://localhost:8080/api/calculator

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api/calculator
```

### Endpoints

#### 1. Calculate Operation
**POST** `/calculate`

Performs mathematical calculations based on input parameters.

**Request Body:**
```json
{
    "firstNumber": 10.5,
    "secondNumber": 5.2,
    "operation": "add"
}
```

**Supported Operations:**
- `add`, `addition`, `+` - Addition
- `subtract`, `subtraction`, `-` - Subtraction
- `multiply`, `multiplication`, `*` - Multiplication
- `divide`, `division`, `/` - Division
- `power`, `exponent`, `^` - Power/Exponent
- `modulo`, `mod`, `%` - Modulo

**Response (Success):**
```json
{
    "result": 15.7,
    "message": "Calculation successful",
    "operation": "+",
    "firstNumber": 10.5,
    "secondNumber": 5.2
}
```

**Response (Error):**
```json
{
    "result": null,
    "message": "Division by zero is not allowed",
    "operation": "/",
    "firstNumber": 10.0,
    "secondNumber": 0.0
}
```

#### 2. Health Check
**GET** `/health`

Returns the health status of the API.

**Response:**
```
Calculator API is running!
```

#### 3. Supported Operations
**GET** `/operations`

Returns a list of supported mathematical operations.

**Response:**
```json
[
    "add, addition, +",
    "subtract, subtraction, -",
    "multiply, multiplication, *",
    "divide, division, /",
    "power, exponent, ^",
    "modulo, mod, %"
]
```

## 🧪 Testing the API

### Using the Web Interface
1. Open http://localhost:8080 in your browser
2. Enter two numbers
3. Select an operation
4. Click "Calculate" to see the result

### Using cURL
```bash
# Addition
curl -X POST http://localhost:8080/api/calculator/calculate \
  -H "Content-Type: application/json" \
  -d '{"firstNumber": 15, "secondNumber": 7, "operation": "add"}'

# Multiplication
curl -X POST http://localhost:8080/api/calculator/calculate \
  -H "Content-Type: application/json" \
  -d '{"firstNumber": 12, "secondNumber": 3, "operation": "multiply"}'

# Division
curl -X POST http://localhost:8080/api/calculator/calculate \
  -H "Content-Type: application/json" \
  -d '{"firstNumber": 20, "secondNumber": 4, "operation": "divide"}'
```

### Using Postman
1. Create a new POST request to `http://localhost:8080/api/calculator/calculate`
2. Set Content-Type header to `application/json`
3. Add request body in JSON format:
   ```json
   {
       "firstNumber": 25,
       "secondNumber": 5,
       "operation": "power"
   }
   ```

## 🏗️ Project Structure

```
calculator-Demo/
├── src/
│   ├── main/
│   │   ├── java/org/example/
│   │   │   ├── CalculatorApplication.java      # Main Spring Boot class
│   │   │   ├── controller/
│   │   │   │   └── CalculatorController.java   # REST API endpoints
│   │   │   ├── service/
│   │   │   │   └── CalculatorService.java      # Business logic
│   │   │   └── dto/
│   │   │       ├── CalculatorRequest.java      # Request DTO
│   │   │       └── CalculatorResponse.java     # Response DTO
│   │   └── resources/
│   │       ├── application.properties          # Configuration
│   │       └── static/
│   │           └── index.html                  # Web interface
│   └── test/
├── pom.xml                                     # Maven configuration
└── README.md                                   # This file
```

## 🔧 Configuration

The application runs on port 8080 by default. You can modify the configuration in `src/main/resources/application.properties`:

```properties
# Change port
server.port=8080

# Enable/disable logging
logging.level.org.example=DEBUG
```

## 🚨 Error Handling

The API provides comprehensive error handling for:
- **Validation Errors**: Missing or invalid input parameters
- **Mathematical Errors**: Division by zero, invalid operations
- **System Errors**: Internal server errors with proper HTTP status codes

## 🌐 CORS Support

The API supports Cross-Origin Resource Sharing (CORS) for frontend integration. All origins are allowed by default.

## 📝 Validation Rules

- **Numbers**: Must be between -999,999,999.99 and 999,999,999.99
- **Operation**: Must be one of the supported operations
- **Required Fields**: All fields are mandatory

## 🚀 Deployment

### JAR File
```bash
mvn clean package
java -jar target/calculator-Demo-1.0-SNAPSHOT.jar
```

### Docker (if needed)
```dockerfile
FROM openjdk:17-jdk-slim
COPY target/calculator-Demo-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 🤝 Contributing

Feel free to contribute to this project by:
- Adding new mathematical operations
- Improving error handling
- Enhancing the web interface
- Adding unit tests

## 📄 License

This project is open source and available under the MIT License.

## 🆘 Support

If you encounter any issues or have questions:
1. Check the console logs for error details
2. Verify the API endpoints are accessible
3. Ensure all required fields are provided in requests

---

**Happy Calculating! 🧮✨**
