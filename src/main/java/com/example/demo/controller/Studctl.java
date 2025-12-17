package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Studentity;
import com.example.demo.service.Studservice;

@RestController
@RequestMapping("/student")
public class Studctl {

    private final Studservice ser;

    public Studctl(Studservice ser) {
        this.ser = ser;
    }

    // Add student
    @PostMapping("/add")
    public ResponseEntity<Studentity> addStudent(@RequestBody Studentity st) {
        Studentity savedStudent = ser.insertStudentity(st);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // Get all students
    @GetMapping("/getAll")
    public ResponseEntity<List<Studentity>> getAllStudents() {
        List<Studentity> students = ser.getAllStudentity();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Get student by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Studentity> getStudent(@PathVariable Long id) {
        Optional<Studentity> student = ser.getOneStudent(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update student
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Studentity newStudentity) {
        Optional<Studentity> student = ser.getOneStudent(id);

        if (student.isPresent()) {
            newStudentity.setId(id);
            ser.insertStudentity(newStudentity);
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
    }

    // Delete student
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Optional<Studentity> student = ser.getOneStudent(id);

        if (student.isPresent()) {
            ser.deleteStudent(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
    }
}
