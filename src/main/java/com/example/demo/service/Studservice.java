package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Studentity;

public interface Studservice {

    // Add or update a student
    Studentity insertStudentity(Studentity st);

    // Get all students
    List<Studentity> getAllStudentity();

    // Get student by id
    Optional<Studentity> getOneStudent(Long id);

    // Delete student by id
    void deleteStudent(Long id);
}
