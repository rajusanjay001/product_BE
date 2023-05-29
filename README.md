# Product and Review service

# To convert the project to gradel ,go to location in project which contains pom.xml and run gradle init 


This Project will demosstrate the use of the follwing.

1) JWT .
2) Spring Boot in memory H2 DB.
3) Rest template example for external API and internal microservice.
4) JPA.
5) REST.
6) Auth and Unauth API.
7) Docker.
8) How to load the data during the start of the application using post construct and using data.xml file.


**Docker files are present in the docker folder**

1)For Review services

docker-compose -f review-compose.yml up

2)For Product Services

docker-compose -f product-compose.yml up


 1)The docker image for the product service can be found here :https://hub.docker.com/r/rajusanjay001/product_microservice

  Product service runs on port **8080**

2)The docker image for the review service can be found here : https://hub.docker.com/r/rajusanjay001/review_microservice

  Product service runs on port **8090**
  
 **I have used in memory H2 for database and added scripts in data.sql for prepopulating the reviews for few of the products  and added 2 users for authentication using @PostConstruct since it is a POC** 

  For the authented api flow ,to get the jwt token  use the below credentials

{"userName": "raju",
"password": "password"}
  
  
  Note: please import the postman collection to know more about the authenticated endpoint for the write operations in review services
  
  **I have used the public api that was given but the API does not respond .I have given a timeout for the first api call in product service and printed the review for the product if it times out**
  
  if there is a alternative api for the product service please change the property 
  
  **product.detail.url**
  
  product.detail.url=https://www.adidas.co.uk/api/products

