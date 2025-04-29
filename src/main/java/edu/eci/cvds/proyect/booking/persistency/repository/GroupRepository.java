package edu.eci.cvds.proyect.booking.persistency.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.eci.cvds.proyect.booking.persistency.entity.Group;

@Repository
public interface GroupRepository extends MongoRepository<Group, Integer> {

}
