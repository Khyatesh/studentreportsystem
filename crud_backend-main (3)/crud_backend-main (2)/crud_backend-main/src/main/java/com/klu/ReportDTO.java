// ReportDTO.java
package com.klu;

public class ReportDTO {
    private int id;
    private int studentId;
    private int subjectId;
    private double attendancePercentage;
    private String grade;
    private String remarks;

    public ReportDTO(int id, int studentId, int subjectId, double attendancePercentage, String grade, String remarks) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.attendancePercentage = attendancePercentage;
        this.grade = grade;
        this.remarks = remarks;
    }

    // Getters and Setters
    public int getId() { return id; }
    public int getStudentId() { return studentId; }
    public int getSubjectId() { return subjectId; }
    public double getAttendancePercentage() { return attendancePercentage; }
    public String getGrade() { return grade; }
    public String getRemarks() { return remarks; }
}
