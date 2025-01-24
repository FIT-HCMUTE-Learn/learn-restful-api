package com.landingis.api.service;

import com.landingis.api.bean.User;
import com.landingis.api.repository.UserStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserStaticService {

    @Autowired
    private UserStaticRepository userStaticRepository;

    public List<User> findAll(){
        return userStaticRepository.findAll();
    }

    public User findById(int id){
        return userStaticRepository.findById(id);
    }

    public User save(User user){
        return userStaticRepository.save(user);
    }

    public User deleteById(int id){
        return userStaticRepository.deleteById(id);
    }
}
