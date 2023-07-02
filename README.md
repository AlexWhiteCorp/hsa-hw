# Highload Software Architecture 
## Homework 3 :: Resources monitoring

docker-compose contains TIG(Telegraf + InfluxDB + Grafana) stack and sample backend infrastructure:
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

### Repo contains prepared Dashboard for Grafana:
* CPU Usage statistic per service
* Memory Usage statistic per service
* Total CPU units available for docker
* Total memory available for docker
* Total services running
* CPU Global Usage(all service)
* Memory Global Usage(all service + total usage + machine limit)
* Network Global Usage IN/OUT(all service)
* Disk Global Usage READ/WRITE(all service)

![image info](./docs/dashboard-1.png)
![image info](./docs/dashboard-2.png)

### Backend logic
* nginx --(proxy)--> book-search-service
* book-search-service --(find books by search query)--> ElasticSearch
* book-search-service --(find books by returned list of id)--> MongoDb

## Usage
Build backend service
```
cd book-search-service
mvn clean package
```

Start up local stack
```
docker-compose up
```

Load test data to service(books fetched from Google API)
```
./book-search-service/init.sh
```

## Load Testing
Use prepared script to run Apache Benchmark test(200 requests, 10 concurrency)
```
./load-testing.sh
```
<img src="./docs/load-testing-1.png" width="50%"/>
<img src="./docs/load-testing-2.png"/>