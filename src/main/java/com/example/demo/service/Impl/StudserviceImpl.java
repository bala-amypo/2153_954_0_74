package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Studentity;
import com.example.demo.repository.StudRepo;
import com.example.demo.service.Studservice;

@Service
public class StudserviceImpl implements Studservice {

    private final StudRepo repo;

    public StudserviceImpl(StudRepo repo) {
        this.repo = repo;
    }

    @Override
    public Studentity insertStudentity(Studentity st) {
        return repo.save(st);
    }

    @Override
    public List<Studentity> getAllStudentity() {
        return repo.findAll();
    }

    @Override
    public Optional<Studentity> getOneStudent(Long id) {
        return repo.findById(id);
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
