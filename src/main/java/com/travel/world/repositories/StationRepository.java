package com.travel.world.repositories;


import com.travel.world.dao.Station;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StationRepository extends MongoRepository<Station,String> {
    Station findById(String id);
}
