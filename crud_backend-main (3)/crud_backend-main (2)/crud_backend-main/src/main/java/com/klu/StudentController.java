package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public String insert(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }

    @GetMapping
    public List<Student> display() {
        return studentService.getAllStudents();
    }

    @PutMapping
    public String update(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}
