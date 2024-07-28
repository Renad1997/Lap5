package com.example.lap5.Controller;

import com.example.lap5.Api.ApiResponse;
import com.example.lap5.Model.Student;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Student")
public class StudentController {

  ArrayList<Student> students = new ArrayList<Student>();

  @GetMapping("/get")
  public ArrayList<Student> getStudents() {
    return students;
  }

  @PostMapping("/add")
  public ApiResponse addStudent(@RequestBody Student student) {
    students.add(student);
    return new ApiResponse("Student Added Successfully");
  }

  @PutMapping("/update/{index}")
  public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student) {
    students.set(index, student);
    return new ApiResponse("Student Updated Successfully");
  }

  @DeleteMapping("/delete/{index}")
  public ApiResponse deleteStudent(@PathVariable int index) {
    students.remove(index);
    return new ApiResponse("Student Deleted Successfully");
  }

  @GetMapping("/name/{index}")
  public ApiResponse getStudentName(@PathVariable int index) {
    if (index < students.size()) {
      return new ApiResponse(students.get(index).getName());
    }
    return new ApiResponse("Student Name Not Found");
  }

  @GetMapping("/age/{index}")
  public ApiResponse getStudentAge(@PathVariable int index) {
    if (index < students.size()) {
      String age = Integer.toString(students.get(index).getAge());
      return new ApiResponse("Student Age is: " + age);
    }
    return new ApiResponse("Student Age Not Found");
  }

  @GetMapping("/college/degree/{index}")
  public ApiResponse getStudentCollege(@PathVariable int index) {
    if (index < students.size()) {
      return new ApiResponse("Student College is: " + students.get(index).getDegree());
    }
    return new ApiResponse("Student College Not Found");
  }

  @GetMapping("/study/status/{index}")
  public ApiResponse getStudentStatus(@PathVariable int index) {
    if (index < students.size()) {
      if (students.get(index).getStatus().equals("graduated")) {
        return new ApiResponse("True");
      }
      else if (students.get(index).getStatus().equals("ungraduated")) {
        return new ApiResponse("False");
      }
    }
  return new ApiResponse("Student Status Not Found");
  }


}