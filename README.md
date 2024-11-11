# Fulfillment API

This is an API for managing products in various fulfillment centers.

## Steps to start

1. Clone the repository 

2. Build and run containers using Docker Compose:
```
   docker-compose up -d
```
   
4. Launch the application

# Swagger 
After launching the application, you can go to the api description
URL: http://localhost:8080/swagger-ui/index.html#/

# Description API
Receiving all products
GET /api/products

Response example:
```
[
  {
    "id": 1,
    "productId": "p1",
    "status": "Sellable",
    "fulfillmentCenter": "fc5",
    "quantity": 4,
    "value": 400.00
  },
 
  ...
]
```

Adding a new product
POST /api/products

Example request body:
```
{
  "productId": "p11",
  "status": "Sellable",
  "fulfillmentCenter": "fc1",
  "quantity": 10,
  "value": 1500.00
}
```

Receiving a product by ID
GET /api/products/{id}

Response example:
```
{
  "id": 1,
  "productId": "p1",
  "status": "Sellable",
  "fulfillmentCenter": "fc5",
  "quantity": 4,
  "value": 400.00
}
```

Product Update
PUT /api/products/{id}

Example request body:
```
{
  "productId": "p1",
  "status": "Unfulfillable",
  "fulfillmentCenter": "fc5",
  "quantity": 10,
  "value": 1000.00
}
```

Removing a product
DELETE /api/products/{id}
