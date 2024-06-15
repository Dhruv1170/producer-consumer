# producer-consumer

**Setup**:

- **Prerequisites**:
  1.Java JDK 17 installed
  2.Maven installed
  3.IDE (like IntelliJ IDEA or Eclipse) or any text editor

**Command to pull project from git and run**:

- git clone https://github.com/404sahil/producer-consumer.git
- cd spring-boot-producer-consumer
- mvn clean install
- mvn spring-boot:run

**Endpoint to test**
POST http://localhost:8080/api/producer/send
RESPONSE:
{
"totalMessages": 0,
"errorsCount": 0
}
