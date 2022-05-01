# baraka-assignment


Minimal [Spring Boot](http://projects.spring.io/spring-boot/) app.

## Requirements

For building and running the application you need:

- JDK 11
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.baraka.assignment.BarakaAssignmentApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Dockerizing the app

To create an image from our Dockerfile, we have to run ‘docker build' like before:

```shell
docker build --tag=baraka-assignment:latest .
```

To run the container from our image

```shell
docker run -p8080:8888 baraka-assignment:latest
```


# Sample Requests


### Create Account

```shell
curl -X POST -H "Content-type: application/json" -d "{\"title\" : \"John Doe\"}" "http://localhost:8080/accounts/create"
```
