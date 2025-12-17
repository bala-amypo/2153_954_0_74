package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Studentity;

public interface Studservice {

    Studentity insertStudentity(Studentity st);

    List<Studentity> getAllStudentity();

    Optional<Studentity> getOneStudent(Long id);

    void deleteStudent(Long id);
}
