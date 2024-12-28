package com.redis.spring_redis.service;

import com.redis.spring_redis.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    // create
    User create(User user);

    // get-all
    List<User> getAll();

    // get by id
    User getById(Long id);


    // delete by id
    void deleteUsingId(Long id);


    // update
    User update(Long id,User user);

    // find by name and city
    User getByNameAndCity(String name,String city);


}
