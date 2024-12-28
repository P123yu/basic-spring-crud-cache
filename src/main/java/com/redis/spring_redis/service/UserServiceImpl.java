package com.redis.spring_redis.service;

import com.redis.spring_redis.model.User;
import com.redis.spring_redis.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    @CacheEvict(allEntries = true)
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    @Cacheable
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    @Cacheable(key="#id")
    public User getById(Long id) {
        return userRepo.findById(id).orElseThrow(()->new NoSuchElementException("not found"));
    }

    @Override
    @CacheEvict(allEntries = true)
    public void deleteUsingId(Long id) {
          userRepo.deleteById(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public User update(Long id, User user) {
        boolean result=userRepo.existsById(id);
        if(result){
            user.setId(id);
            return userRepo.save(user);
        }
        throw new NoSuchElementException("not found");
    }

    @Override
    @Cacheable(key="#name+':'+#city")
    public User getByNameAndCity(String name, String city) {
        return userRepo.findByNameAndCity(name, city);
    }

}
