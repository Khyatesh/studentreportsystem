package com.klu;

import javax.persistence.*;

@Entity
@Table(name = "student_logins")
public class StudentLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    // Optional: link to student details
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}
