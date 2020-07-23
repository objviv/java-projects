# MarketPlace for Self Employed

A simple RESTful service for employers to create projects and self-employed to bid on.

You can run it (if you are using Maven) with

```
$ mvn clean spring-boot:run
```

You can build it into a Docker container and run it as follows

```
$ docker build -t com.intuit.martech.marketplaceservice:v1.0 .
$ docker run -p 8080:8080 com.intuit.martech.marketplaceservice:v1.0
```

Then use curl as follows:

```
$ curl http://localhost:8080/sellers - get a list of all sellers.
$ curl http://localhost:8080/sellers/{id} - get information on a specific seller.
$ curl http://localhost:8080/sellers/{id}/projects - get a list of all projects created by a specific seller.
$ curl -H "Accept: application/json" -X POST --data '{"description":"MarketPlace - create a RESTful API for sellers to post projects",\
                                                      "maxBudget":10000,\
                                                      "currency":"USD",\
                                                      "bidsAccepted":"2020-08-01T12:00:00.000Z"}' http://localhost:8080/sellers/{id}/projects - create a project by a specific seller.
$ curl http://localhost:8080/sellers/{id}/projects/{projectId} - get a project by it's id including the lowest bid amount.                                                     
$ curl http://localhost:8080/buyers - get a list of all buyers/bidders/self-employed.
$ curl http://localhost:8080/buyers/{id} - get information on a specific bidder.
$ curl -H "Accept: application/json" -X POST --data '{"fixedBidAmount":9500}' http://localhost:8080/buyers/{id}/bid/{projectId} - bid on a specific project by a specific bidder.

```

