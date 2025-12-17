package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.sterotype.Repository;
import com.example.demo.entity.Student;

@Repository
public interface Studrepo extends JpaRepository<Student,Long>{

}