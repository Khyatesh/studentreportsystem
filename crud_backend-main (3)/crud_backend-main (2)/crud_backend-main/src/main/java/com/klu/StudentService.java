package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String insertStudent(Student student) {
        studentRepository.save(student);
        return "✅ Student inserted successfully";
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public String updateStudent(Student student) {
        if(studentRepository.existsById(student.getId())) {
            studentRepository.save(student);
            return "✅ Student updated successfully";
        } else {
            return "❌ Student not found";
        }
    }

    public String deleteStudent(int id) {
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "✅ Student deleted successfully";
        } else {
            return "❌ Student not found";
        }
    }
}
