# hiberus
Bill the sum of all products to user in Bill and Call Logistic service to create a sent order

Ricardo Avendaño Casas

To execute the project the following steps must be performed

Important prerequisites
	1. Java 8
	2. Docker

1. Used Frameworks:
	1. Maven
	2. JUnit 4
	3. Spring boot 4
	4. Swagger
	5. Api Rest
	6. Docker
	7. GitHub
	8. H2 data base
	9. Hibernate
	10. JPA
	11. Java 8
2. Download source code from github: git clone https://github.com/ricardoavendano/order.git
3. Go to the directory where the source is and compile: mvn clean package (Docker image is created)
4. See the created Docker image: docker images
5. Create application jar: mvn clean install (the jar is in the path: target/order-0.0.1-SNAPSHOT.jar)
6. It can be executed in two ways:
	1. Run Docker image: docker run -d -p 8080:8080 --name microservice order-micro-service-spring-boot-0.0.1-SNAPSHOT
		The application is already deployed locally in the url: http://localhost:8080
	2. Run jar from target folder: java -jar order-0.0.1-SNAPSHOT.jar
		The application is already deployed locally in the url: http://localhost:8081
7. Application endpoint
	1. POST http://localhost:8081/ecommerce/recibe/order (Create record in the Client and Product table of the h2 database)
			body example:
			{
			  "clientId": 1,
			  "dateTime": "2020-06-27T03:25:22.576Z",
			  "direction": "Calle 1",
			  "productRequestMapping": [
				{
				  "cost": 2,
				  "id": 1,
				  "quantity": 3
				},
				{
				  "cost": 5,
				  "id": 2,
				  "quantity": 4
				},
				{
				  "cost": 6,
				  "id": 3,
				  "quantity": 7
				}
			  ]
			}
	2. GET http://localhost:8081/ecommerce/create/sent-order/client/{clientId} (Consult the client and associated products, calculate the total purchase price)
8. Entering the H2 database
	url: http://localhost:8081/ecommerce/h2-console/login.jsp
	JDBC URL: jdbc:h2:mem:ecommerce
	User name: hiberus
	Password: hiberus
	Tables: CLIENT, PRODUCT
9. Unit tests with JUnit 4, total project coverage 84.5%
10. Using Swagger to view and consume services
	http://localhost:8081/ecommerce/swagger-ui.html#


