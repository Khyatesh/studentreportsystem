package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public String insert(@RequestBody Subject subject) {
        return subjectService.insertSubject(subject);
    }

    @GetMapping
    public List<Subject> getAll() {
        return subjectService.getAllSubjects();
    }

    @PutMapping
    public String update(@RequestBody Subject subject) {
        return subjectService.updateSubject(subject);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return subjectService.deleteSubject(id);
    }
}
