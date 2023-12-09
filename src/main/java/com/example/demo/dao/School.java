package com.example.demo.dao;


import org.springframework.beans.factory.annotation.Autowired;

public class School {

    private Student student;

    @Autowired
   public School(Student st){
    this.student =st;
}
public void getStudent(){

    System.out.println(student.name);

}


}
