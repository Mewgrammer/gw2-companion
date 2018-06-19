package com.gw2companion.main;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
class Config extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return "springdata";
    }
}
