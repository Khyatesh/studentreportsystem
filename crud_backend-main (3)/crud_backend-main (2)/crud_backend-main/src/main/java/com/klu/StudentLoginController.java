package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student-logins")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentLoginController {

    @Autowired
    private StudentLoginService studentLoginService;

    @PostMapping
    public String insert(@RequestBody StudentLogin studentLogin) {
        return studentLoginService.insertStudentLogin(studentLogin);
    }

    @GetMapping
    public List<StudentLogin> getAll() {
        return studentLoginService.getAllStudentLogins();
    }
    @PostMapping("/validate")
    public String validateLogin(@RequestBody StudentLogin login) {
        boolean valid = studentLoginService.validateLogin(login.getUsername(), login.getPassword());
        return valid ? "Login Successful" : "Invalid username or password";
    }

}
