# College Departments

## Get Request

### 1. Get All Departments

#### URL - https://spring-boot-departments.onrender.com/departments

#### Response

```json
[
    {
        "departmentId": 1,
        "departmentName": "IT",
        "departmentAddress": "Chennai",
        "departmentCode": "IT-34"
    },
    {
        "departmentId": 2,
        "departmentName": "CSE",
        "departmentAddress": "Chennai",
        "departmentCode": "IT-34"
    },
    {
        "departmentId": 3,
        "departmentName": "MECH",
        "departmentAddress": "Chennai",
        "departmentCode": "IT-34"
    },
    {
        "departmentId": 4,
        "departmentName": "ECE",
        "departmentAddress": "Chennai",
        "departmentCode": "IT-34"
    },
    {
        "departmentId": 5,
        "departmentName": "EEE",
        "departmentAddress": "Chennai",
        "departmentCode": "IT-34"
    }
]
```

### 2. Get Department By ID

#### URL - https://spring-boot-departments.onrender.com/departments/1

#### Response

```json
{
  "departmentId": 1,
  "departmentName": "IT",
  "departmentAddress": "Chennai",
  "departmentCode": "IT-34"
}
```

### 3. Get Department By Name

#### URL - https://spring-boot-departments.onrender.com/departments/name/IT

#### Response

```json
{
  "departmentId": 1,
  "departmentName": "IT",
  "departmentAddress": "Chennai",
  "departmentCode": "IT-34"
}
```

## Post Request

#### URL - https://spring-boot-departments.onrender.com/departments

#### Request Body

```json
{
    "departmentName": "IT",
    "departmentAddress": "Chennai",
    "departmentCode": "IT-34"
}
```

#### Response

```json
{
    "departmentId": 1,
    "departmentName": "IT",
    "departmentAddress": "Chennai",
    "departmentCode": "IT-34"
}
```

## Put Request

#### URL - https://spring-boot-departments.onrender.com/departments/1

#### Request Body

```json
{
    "departmentName": "IT",
    "departmentAddress": "Chennai",
    "departmentCode": "IT-34"
}
```
#### Response

```json
{
    "departmentId": 1,
    "departmentName": "IT",
    "departmentAddress": "Chennai",
    "departmentCode": "IT-34"
}
```

## Delete Request

#### URL - https://spring-boot-departments.onrender.com/departments/1

#### Response

```
Department deleted successfully
```

