# Task

This repository contains a basic task. 

## Build and run

```sh
$ mvn spring-boot:run
```

## CRUD - examples
### Create
```sh
$ curl -i -X POST -H "Content-Type:application/json" -d '{ "id": 10001, "firstName" : "lakhan", "lastName" : "Kumar" }' localhost:8080/user
```
### Delete
```sh
$ curl -X DELETE http://localhost:8080/user/{id}
```
### Read
```sh
curl http://localhost:8080/users/{id}
```

### PUT
```sh
curl -i PUT -H "Content-Type:application/json" -d '{ "id": 10001, "firstName" : "lakhan", "lastName" : "Kumar" }' localhost:8080/user/
```



##Suggestion Builder
I haven't modified the signature as asked, so I guess standard tests that you have designed should work. However to use Collection benefits, I have overrided hashCode() and equals() method of Suggestion class. 

