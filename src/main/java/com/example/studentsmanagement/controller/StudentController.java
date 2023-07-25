package com.example.studentsmanagement.controller;

import com.example.studentsmanagement.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentMapper studentMapper;
}
