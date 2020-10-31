package com.ejemplo.mvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.mvc.models.DataBaseSequence;

@Repository("dataBaseSequenceRepository")
public interface DataBaseSequenceRepository extends MongoRepository<DataBaseSequence, String> {

}
