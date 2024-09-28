package com.microservice.student.service;

import java.util.Optional;

import com.microservice.student.dto.School;
import com.microservice.student.dto.StudentResponse;
import com.microservice.student.entity.Student;
import com.microservice.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService
{
  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private RestTemplate restTemplate;

  public Student createStudent(Student student)
  {
    return studentRepository.save(student);
  }

  public StudentResponse getStudentById(Integer id)
  {
    Optional<Student> student = studentRepository.findById(id);
    if (student.isPresent())
    {
      School school =
        restTemplate.getForObject("http://SCHOOL-SERVICE/school/" + student.get().getSchoolId(), School.class);
      return new StudentResponse(student.get().getId(),
                                 student.get().getName(),
                                 student.get().getAge(),
                                 student.get().getGender(),
                                 school);
    }
    return null;
  }
}
