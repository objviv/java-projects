# FibonacciService

A simple RESTful Fibonacci generator service.

You can run it (if you are using Maven) with

```
$ mvn clean spring-boot:run
```

You can build it into a Docker container and run it as follows

```
$ docker build -t us.co.onecloud.fibonacciservice:1.0 .
$ docker run -p 8080:8080 us.co.onecloud.fibonacciservice:1.0
```

Then use curl as follows:

```
$ curl http://localhost:8080/fibonacci/5
```

