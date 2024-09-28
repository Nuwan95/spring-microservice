package com.microservice.school.controller;

import java.util.List;

import com.microservice.school.entity.School;
import com.microservice.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/school")
@RestController
public class SchoolController
{
  @Autowired
  SchoolService schoolService;

  @PostMapping
  public School addSchool(@RequestBody School school)
  {
    return schoolService.addSchool(school);
  }

  @GetMapping
  public List<School> getAllSchools()
  {
    return schoolService.getAllSchools();
  }

  @GetMapping("/{id}")
  public School getSchool(@PathVariable int id)
  {
    return schoolService.getSchool(id);
  }
}
