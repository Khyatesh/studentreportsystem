package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public String insertSubject(Subject subject) {
        subjectRepository.save(subject);
        return "✅ Subject inserted successfully";
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public String updateSubject(Subject subject) {
        if(subjectRepository.existsById(subject.getId())) {
            subjectRepository.save(subject);
            return "✅ Subject updated successfully";
        } else {
            return "❌ Subject not found";
        }
    }

    public String deleteSubject(int id) {
        if(subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return "✅ Subject deleted successfully";
        } else {
            return "❌ Subject not found";
        }
    }
}
