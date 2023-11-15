package com.springBoot.FullStackBackEnd.service;

import com.springBoot.FullStackBackEnd.exception.UserNotFoundException;
import com.springBoot.FullStackBackEnd.model.User;
import com.springBoot.FullStackBackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User postUser(User user) {

        return userRepository.save(user);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }


    public User getById(Long id) {
        return userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException(id));
    }

    public User updateUser(Long id, User editUser) {
        return userRepository.findById(id)
                .map(user->{
                   user.setName(editUser.getName());
                   user.setUsername(editUser.getUsername());
                   user.setEmail(editUser.getEmail());
                   return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));

    }

    public String deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
         userRepository.deleteById(id);
         return "Deleted "+id;
    }
}
