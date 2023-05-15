# Product and Review service

1)Product and related microservice

  The docker image for the product service can be found here :https://hub.docker.com/r/rajusanjay001/product_microservice

  Product service runs on port **8080**



2) The docker image for the review service can be found here : https://hub.docker.com/r/rajusanjay001/review_microservice

  Product service runs on port **8090**

  For the authente api to get the jwt token  use the below credentials

{"userName": "raju",
"password": "password"}
  
  
  Note: please import the postman collection to know more about the authenticated endpoint for the write operations in review services
  
  **I have used the public api that was given but the API does not respond .I have given a timeout for the first api call in product service and printed the review for the product if it times out**
