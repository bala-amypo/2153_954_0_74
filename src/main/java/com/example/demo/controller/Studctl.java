package com.example.demo.controller;

import java.util.List;
impory java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Studentity;
impory com.example.demo.service.Studservice;
@RestController
@RequestMapping("/student")
public class Studctl{
    private final Studservice ser;

    @Autowired
    public Studctl(Studservice )
}