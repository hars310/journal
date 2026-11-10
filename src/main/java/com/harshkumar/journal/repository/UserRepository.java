package com.harshkumar.journal.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.harshkumar.journal.entity.User;

public interface UserRepository extends MongoRepository<User,ObjectId>{
    
}
