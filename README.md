# Task

This repository contains a basic task. 

## Build and run

```sh
$ mvn spring-boot:run
```

## CRUD - examples
### Create
```sh
$ curl -i -X POST -H "Content-Type:application/json" -d '{ "firstName" : "lakhan", "lastName" : "Kumar" }' localhost:8080/users
```
### Delete
```sh
$ curl -X DELETE http://localhost:8080/users/{id}
```
### Read
```sh
curl http://localhost:8080/users/{id}
```
