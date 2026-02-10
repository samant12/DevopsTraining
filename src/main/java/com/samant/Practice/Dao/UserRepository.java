package com.samant.Practice.Dao;

import com.samant.Practice.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {



    Optional<User> findByUserName(String userName);

}
