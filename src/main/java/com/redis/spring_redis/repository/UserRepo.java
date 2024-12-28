package com.redis.spring_redis.repository;

import com.redis.spring_redis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByNameAndCity(String name,String city);
}
