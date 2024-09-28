package com.microservice.school.service;

import java.util.List;

import com.microservice.school.entity.School;
import com.microservice.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService
{
  @Autowired
  private SchoolRepository schoolRepository;

  public School addSchool(School school)
  {
    return schoolRepository.save(school);
  }

  public School getSchool(int id)
  {
    return schoolRepository.findById(id).orElse(null);
  }

  public List<School> getAllSchools()
  {
    return schoolRepository.findAll();
  }
}
