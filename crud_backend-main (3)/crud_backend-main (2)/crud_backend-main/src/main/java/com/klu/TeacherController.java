package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public String insert(@RequestBody Teacher teacher) {
        return teacherService.insertTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> getAll() {
        return teacherService.getAllTeachers();
    }
    @PostMapping("/validate")
    public String validateLogin(@RequestBody Teacher teacher) {
        boolean valid = teacherService.validateTeacherLogin(
            teacher.getUsername(),
            teacher.getPassword()
        );
        return valid ? "Login Successful" : "Invalid username or password";
    }
}
