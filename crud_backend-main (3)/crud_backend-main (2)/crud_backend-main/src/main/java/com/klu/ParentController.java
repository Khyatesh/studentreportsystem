package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @PostMapping
    public String insert(@RequestBody Parent parent) {
        return parentService.insertParent(parent);
    }

    @GetMapping
    public List<Parent> getAll() {
        return parentService.getAllParents();
    }
    @PostMapping("/validate")
    public String validateLogin(@RequestBody Parent parent) {
        boolean valid = parentService.validateParentLogin(parent.getUsername(), parent.getPassword());
        return valid ? "Login Successful" : "Invalid username or password";
    }
}
