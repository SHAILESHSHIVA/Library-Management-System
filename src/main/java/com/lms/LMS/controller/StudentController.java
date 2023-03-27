package com.lms.LMS.controller;

import com.lms.LMS.Dto.StudentEntryDto;
import com.lms.LMS.Dto.UpdateMobileDto;
import com.lms.LMS.Service.StudentService;
import com.lms.LMS.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody StudentEntryDto studentEntryDto){

        String response = studentService.addStudent(studentEntryDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get_user_byEmail/{email}")
    public ResponseEntity<String> getNameByEmail(@PathVariable("email")String email){

        String res = studentService.getUserByEmail(email);

        return new ResponseEntity<String>(res,HttpStatus.FOUND);
    }

    @GetMapping("/get_user_mobile/{mobile}")
    public ResponseEntity<String> getNameByMobile(@PathVariable("mobile")String mobile){

        String res = studentService.getUserByMobile(mobile);

        return new ResponseEntity<String>(res,HttpStatus.FOUND);
    }

    @PutMapping("/updateMobile")
    public ResponseEntity<String> updateMobile(@RequestBody UpdateMobileDto updateMobileDto){
        return new ResponseEntity<>(studentService.updateMobile(updateMobileDto),HttpStatus.CREATED);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){

        return new ResponseEntity<>(studentService.deleteStudent(id),HttpStatus.ACCEPTED);
    }
}
