# Restful API

## Header

### login_header

```
Host: api.orange.com
Authorization: Bearer ACCESS_TOKEN
Content-Type: application/json
Accept: application/json
```

### guest_header

Allow anonymous access without requiring authentication headers

```
Content-Type: application/json
Accept: application/json
```

### Methods：GET,POST

`/v1/products`


### Methods：GET,PUT,PATCH,DELETE

`v1/products/1`


### Pagination get partial data

#### NOTE：

`limit：Querying Data Count
max_id：Absolute position`

`v1/products?limit=10&max_id=3`

Retrieve 10 records starting from ID 3
So, the frontend needs to update max_id with each request

## Grid Table API Examples

### URI

`v1/products`

### Get all data：
Request: `GET v1/products`

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

### Get specific one data：

Request： `Get  v1/products?name=Macbook`

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

### Get specific many datas：

Request： `Get  v1/products?name=Macbook,iPhone`

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

### Sort and order datas：

Request： `Get  v1/products?sort_by=id&order_by=desc`

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

### Get specific many column datas：

Request： `Get  v1/products?fields=id,name`

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

`v1/products/detail`

### Get specific product detail：

Request： `Get  v1/products/detail?name=Macbook`

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
            "like": false,
            "image_url": "XXXXX",
            "create_at": "2023-10-07 12:00:00:000",
            "update_at": "2023-10-07 18:00:00:000"
        }   
    ]
}
```

## Favorite product API Examples

### URI

`v1/products/favorite`

### Post favorite product：

Request： `Post  v1/products/favorite`

```json
{
    "data": [
        {
            "id": 2,
            "name": "Macbook",
            "like": true
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

### Update favorite product：

Request： `Patch  v1/products/favorite`

```json
{
    "data": [
        {
            "id": 2,
            "name": "Macbook",
            "like": false
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

### Delete favorite product：

Request： `Delete  v1/products/favorite`

```json
{
    "data": [
        {
            "id": 2,
            "name": "Macbook"
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
