package com.klu;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(nullable = false, length = 5)
    private String grade;

    @Column(name = "attendance_percentage", precision = 5, scale = 2)
    private double attendancePercentage;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    // Transient fields for frontend
    @Transient
    private String studentName;

    @Transient
    private String subjectName;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public double getAttendancePercentage() { return attendancePercentage; }
    public void setAttendancePercentage(double attendancePercentage) { this.attendancePercentage = attendancePercentage; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    // Transient getters
    public String getStudentName() {
        return student != null ? student.getName() : "";
    }

    public String getSubjectName() {
        return subject != null ? subject.getName() : "";
    }
}
