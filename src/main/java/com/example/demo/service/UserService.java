package com.example.demo.service;
import com.example.demo.model.Userprofile;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
public class UserService {

   @Autowired
    private UserRepository userRepository;


   @RequestMapping("/")
   public String welcome(){
       return "welcome to the world";
   }
   public List<Userprofile> getAllUsers() {
    return this.userRepository.findAll();
   }


   public String addUser(Userprofile user){
       this.userRepository.save(user);
       return "user added successfully";
   }



}
