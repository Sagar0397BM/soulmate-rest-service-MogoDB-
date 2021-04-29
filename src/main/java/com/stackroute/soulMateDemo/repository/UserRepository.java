package com.stackroute.soulMateDemo.repository;

import com.stackroute.soulMateDemo.Domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
    public List<User> findByAge(int age);


}
