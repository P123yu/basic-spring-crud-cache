package com.redis.spring_redis.Controller;

import com.redis.spring_redis.model.User;
import com.redis.spring_redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")

@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/post")
    public User create(@RequestBody User user) {
    return userService.create(user);
   }


    @GetMapping("/get")
    public List<User> getAll() {
        return userService.getAll();
    }


    @GetMapping("/getById/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }


    @DeleteMapping("/deleteById/{id}")
    public void deleteUsingId(@PathVariable Long id) {
        userService.deleteUsingId(id);
    }

   @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
      return userService.update(id,user);
    }


    @GetMapping("/getByNameAndCity/{name}/{city}")
    public User getByNameAndCity(@PathVariable String  name, @PathVariable String city) {
        return userService.getByNameAndCity(name,city);
    }

}
