package com.microservice.student.controller;

import com.microservice.student.dto.StudentResponse;
import com.microservice.student.entity.Student;
import com.microservice.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController
{
  @Autowired
  StudentService studentService;

  @PostMapping
  public Student createStudent(@RequestBody Student student)
  {
    return studentService.createStudent(student);
  }

  @GetMapping("/{id}")
  public StudentResponse getStudentById(@PathVariable int id)
  {
    return studentService.getStudentById(id);
  }
}
