# webmarket
Web market order demo
# Pull from docker hub
docker pull galipp/dockerhub:firstwebmarketpush

# Run docker;
docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 9090:8080 galipp/dockerhub:firstwebmarketpush

# H2 for DEV
http://localhost:9090/h2-console

db url : jdbc:h2:mem:webmarket-dev
username:sa
password:

# Swagger
http://localhost:9090/swagger-ui/index.html
http://localhost:9090/dev

# Create order
http://localhost:9090/order/create

Request;

```json
{
    "customerId": 1,
    "orderDetails": [
        {
            "name": "Telefon",
            "quantity": 1,
            "price": 3000
        },
        {
            "name": "Kalem",
            "quantity": 1,
            "price": 40
        }
    ]
}
```

Response;
```json
{
    "result": {
        "code": "0",
        "message": "Success"
    },
    "createOrderDto": {
        "id": 1,
        "customerId": 1,
        "totalPrice": 3040,
        "status": "ACTIVE",
        "createdDate": "2022-02-14T01:47:41.191+00:00",
        "createdUser": "createSessionUser"
    }
}
```

# List order
http://localhost:9090/order/detailsByOrderId/1

Response;
```json
{
    "result": {
        "code": "0",
        "message": "Success"
    },
    "order": {
        "id": 1,
        "customerId": 1,
        "status": "ACTIVE",
        "createdDate": "2022-02-14",
        "createdUser": "createSessionUser",
        "updatedDate": null,
        "updatedUser": null,
        "totalPrice": 3040.00,
        "orderDetails": [
            {
                "id": 1,
                "name": "Telefon",
                "quantity": 1,
                "price": 3000.00
            },
            {
                "id": 2,
                "name": "Kalem",
                "quantity": 1,
                "price": 40.00
            }
        ]
    }
}
```

# Delete order
http://localhost:9090/order/delete

Request;
```
{
    "id": 1
}
```

Response;
```json
{
    "result": {
        "code": "0",
        "message": "Success"
    },
    "deleteOrderDto": {
        "id": 1,
        "customerId": 1,
        "totalPrice": 3040.00,
        "status": "PASSIVE",
        "createdDate": "2022-02-14",
        "createdUser": "createSessionUser",
        "updatedDate": "2022-02-14T01:57:30.474+00:00",
        "updatedUser": "deleteSessionUser"
    }
}
```
