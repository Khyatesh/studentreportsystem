package com.klu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public String insertReport(Report report) {
        reportRepository.save(report);
        return "✅ Report inserted successfully";
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public String updateReport(Report report) {
        if(reportRepository.existsById(report.getId())) {
            reportRepository.save(report);
            return "✅ Report updated successfully";
        } else {
            return "❌ Report not found";
        }
    }
    public List<Report> getReportsByStudentId(int studentId) {
        return reportRepository.findByStudentId(studentId);
    }

    public String deleteReport(int id) {
        if(reportRepository.existsById(id)) {
            reportRepository.deleteById(id);
            return "✅ Report deleted successfully";
        } else {
            return "❌ Report not found";
        }
    }
}
