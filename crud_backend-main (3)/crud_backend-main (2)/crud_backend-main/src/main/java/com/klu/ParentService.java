package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public String insertParent(Parent parent) {
        parentRepository.save(parent);
        return "✅ Parent account created";
    }

    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }
    public boolean validateParentLogin(String username, String password) {
        return parentRepository.findByUsernameAndPassword(username, password).isPresent();
    }
    
}
