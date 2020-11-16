package com.ejemplo.mvc.persistencia.RepositorioMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.mvc.persistencia.DataBaseSequence;

@Repository("dataBaseSequenceRepository")
public interface DataBaseSequenceRepository extends MongoRepository<DataBaseSequence, String> {

}
