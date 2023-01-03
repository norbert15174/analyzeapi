# analyzeapi

### Run app
- clone project
- build .jar 
> mvn clean package -DSkipTests
- Create network
> docker network create -d bridge analyze-network
- run docker compose
> docker compose up -d

Application port: 8080

- POST /analyze
example json:

Request
``` 
 "text" : "test 123test testtest test b5test"
```

Response
```
[
    {
        "name": "123test",
        "count": 1,
        "positions": [
            2
        ]
    },
    {
        "name": "b5test",
        "count": 1,
        "positions": [
            5
        ]
    },
    {
        "name": "test",
        "count": 2,
        "positions": [
            1,
            4
        ]
    },
    {
        "name": "testtest",
        "count": 1,
        "positions": [
            3
        ]
    }
]
```

- GET /words [PARAMS: name (String), page(int)[not required, default 0], pageSize(int)[not required, default 10]

example response:

```
[
    {
        "name": "test",
        "count": 2,
        "positions": [
            1,
            4
        ],
        "fragments": [
            {
                "id": 4,
                "text": "test 123test testtest test b5test"
            }
        ]
    }
]
```


