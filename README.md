# MicroService-Demo

# Movie Microservice
  
  # Implements
    1. Eureka Client.
    2. Rest API.
    3. InMemory H2 database.
    4. Swagger for doc API.
    5. Messaging Queue - Kafka.
    6. JPA Repository.

  # What Done.
    1. Add some endpoint to get/list/add/search movies.
    2. Swagger for rest end point docs.
    3. In-Memory H2 database so no need to create db externally to test the services.
    4. JPA repository to use their inbuild crud methods.
    5. Add messaging queue kafka dependencies and use messaging queue sender and receiver. for that need to download and run apache-Kafka and zookeeper.
       (note - Will add the commands and url to run and download.)

  # What Next :-
    1. Spring Cloud Config.
    2. Profiling.
    3. Entity Mapping Relations, Indexing, Unique Constraints.
    4. Communicate with different api's.
    5. Communicate via CQRS.
    6. API Logging.
    7. Dockers/Kubernities.
  
# Service Discovery
  1. Add Eureka service discovery on port 8761. (will also try with some other port in future.)
  
# API Gateway
  1. Add Spring Cloud API Gateway to build and route the url to their respective api gateway.
  
  # What NexT
    1. Fault tolarances.
    2. Fallback Methods.
    3. Logging.
    4. Security.
