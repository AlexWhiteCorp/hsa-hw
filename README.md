# Highload Software Architecture 
## Homework 3 :: Resources monitoring

docker-compose contains TIG stack and sample backend infrastructure:
* infrastructure
    * nginx
* databases
    * InfluxDB
    * ElasticSearch
    * MongoDB
* backend
    * book-search-service
* monitoring:
    * grafana
    * telegraf

## Usage
Start up local stack
```
docker-compose up
```

On first run execute next command to provide **telegraf agent** needed access
```
docker exec -u root -it telegraf /bin/sh -c "chmod 666 /var/run/docker.sock"
```

## Load Testing
Use prepared script to run Apache Benchmark test(200 requests, 10 concurrency)
```
./load-testing.sh
```

## Backend logic 
* nginx --(proxy)--> book-search-service
* book-search-service --(find books by search query)--> ElasticSearch
* book-search-service --(find books by returned list of id)--> MongoDb