package com.example.bytefitjava.bytefit.repository;

import com.example.bytefitjava.bytefit.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    User findByEmail(@Param("email") String email);
}
