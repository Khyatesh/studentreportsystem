package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentReportSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentReportSystemApplication.class, args);
        System.out.println("🎓 Student Report System Started...");
    }
}
