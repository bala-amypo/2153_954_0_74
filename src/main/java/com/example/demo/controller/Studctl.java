package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Studentity;
import com.example.demo.service.Studservice;

@RestController
@RequestMapping("/student")
public class Studctl{
    private final Studservice ser;

    @Autowired
    public Studctl(Studservice ser){
        this.ser=ser;
    }

    @postMapping("/add")
    public Studentity addStudent(@RequestBody Studentity st){
        return ser.insertStudentity(st);
    }

    @GetMapping("/getAll")
    public List<Studentity>getAllStudents(){
        return ser.getAllStudentity();
    }

    @GetMapping("/get/{id}")
    public Optional<Studentity> getStudent(@PathVariable Long id){
        return ser.getOneStudent(id);
    }

    @PutMapping("/update/{id}"){
        public String updateStudent(@pathVariable Long id,@RequestBody Studentity newStudentity){
            optinal<Studentity> student = ser.getOneStudent(id);
            if(student.isPresent()){
                newStudentity.setId(id);
                ser.insertStudentity(newStudentity);
                return"Updated Successfully";
            }
            return "ID NOT FOUND";
        }
    }
    @DeleteMapping("/del/{id}")
    public String deleteStudents(@PathVariable Long id){
        Optional<Studentity>student = ser.getOneStudent(id);
        if(student.isPresent()){
            ser.deleteStudent(id);
            return "delete successfully";
        }
        return "ID NOT FOUND";
    }
}