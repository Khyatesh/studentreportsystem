package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public String insertTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return "✅ Teacher account created";
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    public boolean validateTeacherLogin(String username, String password) {
        return teacherRepository.findByUsernameAndPassword(username, password).isPresent();
    }
}
