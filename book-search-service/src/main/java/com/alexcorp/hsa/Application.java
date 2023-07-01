package com.alexcorp.hsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableElasticsearchRepositories(basePackages = "com.alexcorp.hsa.repository.es")
@EnableMongoRepositories(basePackages = "com.alexcorp.hsa.repository.mongo")
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

}
