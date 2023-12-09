package com.example.demo.service;
import com.example.demo.model.Userprofile;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class UserService {

   @Autowired
   private UserRepository userRepository;

    // @Transactional
    //@Cacheable(value = "products")
    public Userprofile addUser(Userprofile user){
       return this.userRepository.save(user);

    }

   // @Cacheable(value = "products")
    public List<Userprofile> getAllUsers() {
       return this.userRepository.findAll();
   }

    public String deleteUser(int id){
        this.userRepository.deleteById(id);
        return "user with the +"+id+" deleted successfully";
    }

    public Page<Userprofile> getData(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


}
