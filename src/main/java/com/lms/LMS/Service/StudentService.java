package com.lms.LMS.Service;

import com.lms.LMS.Dto.StudentEntryDto;
import com.lms.LMS.Dto.UpdateMobileDto;
import com.lms.LMS.Enum.CardStatus;
import com.lms.LMS.model.Card;
import com.lms.LMS.model.Student;
import com.lms.LMS.repository.CardRepository;
import com.lms.LMS.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CardRepository cardRepository;

    public String addStudent(StudentEntryDto studentEntryDto){

        Student student = new Student();

        student.setName(studentEntryDto.getName());
        student.setAge(studentEntryDto.getAge());
        student.setEmail(studentEntryDto.getEmail());
        student.setAddress(studentEntryDto.getAddress());
        student.setMobNo(studentEntryDto.getMobNo());

        Card card = new Card();

        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);


        return "Student added Successfully and his library card is activated";
    }

    public String getUserByEmail(String email){

        Student student = studentRepository.findByEmail(email);

        return student.getName() ;

    }

    public String getUserByMobile(String mobile){

        Student student = studentRepository.findByMobNo(mobile);

        return student.getName();

    }

    public String updateMobile(UpdateMobileDto updateMobileDto){

        Student student = studentRepository.findById(updateMobileDto.getId()).get();

        student.setMobNo(updateMobileDto.getMobile());

        studentRepository.save(student);

        return "Update mobile number successfully";
    }

    public String deleteStudent(int id){

        studentRepository.deleteById(id);

        return "student deleted successfully";
    }
}
