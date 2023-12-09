package com.example.demo.controller;

import com.example.demo.dao.Student;
import com.example.demo.model.Userprofile;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
     private Student s;
    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }


    @PostMapping("/add")
    public ResponseEntity<Userprofile> createEntity(@RequestBody Userprofile user) {
        Userprofile savedEntity = userService.addUser(user);

        return ResponseEntity.ok(savedEntity);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Userprofile>> getAll() {
        s.setName("wow");
        System.out.println("hello"+s.getName());
        List<Userprofile> entities = userService.getAllUsers();

        return ResponseEntity.ok(entities);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return this.userService.deleteUser(id);

    }


    @GetMapping("/api/data")
    public ResponseEntity<Page<Userprofile>> getData(@RequestParam(defaultValue = "1") int page, @RequestParam int size) {
        Page<Userprofile> dataPage = userService.getData(PageRequest.of(page, size));
        System.out.println("hello");
        return ResponseEntity.ok(dataPage);
    }


}
