package com.fatec.product.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fatec.product.entities.Student;
import com.fatec.product.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Long id, Student studentDetails) {
        Student student = findById(id);
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setRa(studentDetails.getRa());
        student.setCourse(studentDetails.getCourse());
        student.setPeriod(studentDetails.getPeriod());
        student.setEnrollmentYear(studentDetails.getEnrollmentYear());
        student.setAge(studentDetails.getAge());
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        studentRepository.delete(student);
    }
}
