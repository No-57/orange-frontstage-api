# Restful API

## Header

### login_header
```
Host: api.orange.com
Authorization: Bearer ACCESS_TOKEN
Content-Type: application/json
Accept: application/json
User-Agent: OrangeApp/1.0

```
### guest_header
`Allow anonymous access without requiring authentication headers`
```

Content-Type: application/json
Accept: application/json
User-Agent: OrangeApp/1.0

```

### Methods：GET，POST
`https://api.orange.com/v1/products`


### Methods：GET，PUT，PATCH，DELETE
`https://api.orange.com/v1/products/1`


### Pagination  get partial data
#### NOTE：
`limit：Querying Data Count
max_id：Absolute position`

`https://api.orange.com/v1/products?limit=10&max_id=3`
Retrieve 10 records starting from ID 3
So, the frontend needs to update max_id with each request

## Grid Table API Examples
### URI
`https://api.orange.com/v1/products`
### Example 1（Get all data）：
Request ：`Get  https://api.orange.com/v1/products`
Response：
```json
{
    "code":200,
    "data": [
        {
            "id": 1,
            "name": "iPhone",
            "type": "cellphone"
        },
        {
            "id": 2,
            "name": "Macbook",
            "type": "notebook"
        },
        {
            "id": 3,
            "name": "AirPods",
            "type": "earpod"
        }      
    ]
}
```

### Example 2（Get specific one data）：
Request ：`Get  https://api.orange.com/v1/products?name=Macbook`
Response：
```json
{
    "code":200,
    "data": [
        {
            "id": 2,
            "name": "Macbook",
            "type": "notebook"
        }   
    ]
}
```

### Example 3（Get specific many data）：
Request ：`Get  https://api.orange.com/v1/products?name=Macbook,iPhone`
Response：
```json
{
    "code":200,
    "data": [
        {
            "id": 1,
            "name": "iPhone",
            "type": "cellphone"
        },
        {
            "id": 2,
            "name": "Macbook",
            "type": "notebook"
        }   
    ]
}
```

### Example 4（Order data）：
Request ：`Get  https://api.orange.com/v1/products?sort_by=id&order_by=desc`
Response：
```json
{
    "code":200,
    "data": [
        {
            "id": 3,
            "name": "AirPods",
            "type": "earpod"
        },
        {
            "id": 2,
            "name": "Macbook",
            "type": "notebook"
        },     
        {
            "id": 1,
            "name": "iPhone",
            "type": "cellphone"
        }
    ]
}
```

### Example 5（Get specific many column data）：
Request ：`Get  https://api.orange.com/v1/products?fields=id,name`
Response：
```json
{
    "code":200,
    "data": [
        {
            "id": 1,
            "name": "iPhone"
        },
        {
            "id": 2,
            "name": "Macbook"
        },
        {
            "id": 3,
            "name": "AirPods"
        }      
    ]
}
```

### Errors example
```json
{
    "code":400,
    "errors": {
        "message": "詳細錯誤資訊 …"
    }
}
```

## Detailed information API Examples
### URI
`https://api.orange.com/v1/products/detail`

### Example 1：
Request ：`Get  https://api.orange.com/v1/products/detail?name=Macbook`
Response：
```json
{
    "code":200,
    "data": [
        {
            "id": 2,
            "name": "Macbook",
            "price": "30000",
            "description": "the newst M2 Macbook 8G/256G",
            "like": "N",
            "image_url": "XXXXX",
            "createAt": "2023-10-07 12:00:00:000",
            "updateAt": "2023-10-07 18:00:00:000"
        }   
    ]
}
```

## Favorite product API Examples
### URI
`https://api.orange.com/v1/products/favorite`

### Example 1：
Request ：`Post  https://api.orange.com/v1/products/detail?name=Macbook`
```json
{
    "data": [
        {
            "id": 2,
            "name": "Macbook",
            "like": "Y"
        }   
    ]
}
```
Response：
```json
{
    "code":200,
    "message": "OK"
}
```

### Example 2：
Request ：`Patch  https://api.orange.com/v1/products/detail?name=Macbook`
```json
{
    "data": [
        {
            "id": 2,
            "name": "Macbook",
            "like": "N"
        }   
    ]
}
```
Response：
```json
{
    "code": 200,
    "message": "OK"
}
```

### Example 3：
Request ：`Delete  https://api.orange.com/v1/products/detail?name=Macbook`
```json
{
    "data": [
        {
            "id": 2,
            "name": "Macbook",
            "like": "N"
        }   
    ]
}
```
Response：
```json
{
    "code": 200,
    "message": "OK"
}
```
