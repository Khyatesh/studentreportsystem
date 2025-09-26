package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLoginService {

    @Autowired
    private StudentLoginRepository studentLoginRepository;

    public String insertStudentLogin(StudentLogin studentLogin) {
        studentLoginRepository.save(studentLogin);
        return "✅ Student login created";
    }

    public List<StudentLogin> getAllStudentLogins() {
        return studentLoginRepository.findAll();
    }
    public boolean validateLogin(String username, String password) {
        return studentLoginRepository.findByUsernameAndPassword(username, password).isPresent();
    }
    
}
