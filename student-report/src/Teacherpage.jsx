import React, { useState } from "react";
import axios from "axios";

export default function TeacherPage() {
  const [studentId, setStudentId] = useState("");          // For fetching reports
  const [reports, setReports] = useState([]);             // Reports fetched
  const [report, setReport] = useState({                  // For add/edit
    id: "", // for editing existing report
    student: { id: "" },
    subject: { id: "" },
    grade: "",
    attendancePercentage: "",
    remarks: ""
  });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  // Fetch reports by student ID
  const fetchReports = async () => {
    if (!studentId) {
      setError("Enter student ID to fetch reports");
      return;
    }
    setError("");
    setLoading(true);
    try {
      const res = await axios.get(`http://localhost:8010/reports/student/${studentId}`);
      setReports(res.data);
    } catch (err) {
      console.error(err);
      setError("Could not fetch reports");
    } finally {
      setLoading(false);
    }
  };

  // Add new report
  const addReport = async () => {
    try {
      await axios.post("http://localhost:8010/reports", report);
      alert("Report added successfully!");
      setReport({ student: { id: "" }, subject: { id: "" }, grade: "", attendancePercentage: "", remarks: "" });
      fetchReports(); // refresh list
    } catch (err) {
      console.error(err);
      alert("Error adding report");
    }
  };

  // Update existing report
  const updateReport = async () => {
    if (!report.id) {
      alert("Please select a report to edit");
      return;
    }
    try {
      await axios.put(`http://localhost:8010/reports/${report.id}`, report);
      alert("Report updated successfully!");
      setReport({ student: { id: "" }, subject: { id: "" }, grade: "", attendancePercentage: "", remarks: "" });
      fetchReports(); // refresh list
    } catch (err) {
      console.error(err);
      alert("Error updating report");
    }
  };

  // Load a report into the form for editing
  const editReport = (r) => {
    setReport({
      id: r.id,
      student: { id: r.student?.id || "" },
      subject: { id: r.subject?.id || "" },
      grade: r.grade || "",
      attendancePercentage: r.attendancePercentage || "",
      remarks: r.remarks || ""
    });
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h2>Teacher Report Management</h2>

      {/* Student ID input + Fetch */}
      <div style={{ marginBottom: "20px" }}>
        <input
          type="number"
          placeholder="Enter Student ID"
          value={studentId}
          onChange={(e) => setStudentId(e.target.value)}
          style={{ marginRight: "10px", padding: "5px" }}
        />
        <button onClick={fetchReports}>View Reports</button>
      </div>

      {/* Error / Loading */}
      {loading && <p>Loading reports...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}

      {/* Form to Add/Edit Report */}
      <div style={{ marginBottom: "20px", border: "1px solid #ccc", padding: "10px", borderRadius: "5px" }}>
        <h3>{report.id ? "Edit Report" : "Add New Report"}</h3>
        <input
          type="number"
          placeholder="Student ID"
          value={report.student.id}
          onChange={(e) => setReport({ ...report, student: { id: e.target.value } })}
          style={{ marginRight: "10px", marginBottom: "10px" }}
        />
        <input
          type="number"
          placeholder="Subject ID"
          value={report.subject.id}
          onChange={(e) => setReport({ ...report, subject: { id: e.target.value } })}
          style={{ marginRight: "10px", marginBottom: "10px" }}
        />
        <input
          type="text"
          placeholder="Grade"
          value={report.grade}
          onChange={(e) => setReport({ ...report, grade: e.target.value })}
          style={{ marginRight: "10px", marginBottom: "10px" }}
        />
        <input
          type="number"
          placeholder="Attendance %"
          value={report.attendancePercentage}
          onChange={(e) => setReport({ ...report, attendancePercentage: e.target.value })}
          style={{ marginRight: "10px", marginBottom: "10px" }}
        />
        <input
          type="text"
          placeholder="Remarks"
          value={report.remarks}
          onChange={(e) => setReport({ ...report, remarks: e.target.value })}
          style={{ marginRight: "10px", marginBottom: "10px" }}
        />
        <div>
          <button onClick={addReport} style={{ marginRight: "10px" }}>Add Report</button>
          <button onClick={updateReport} style={{ marginRight: "10px" }}>Update Report</button>
        </div>
      </div>

      {/* Show fetched reports */}
      {reports.length > 0 && (
        <table border="1" style={{ width: "100%", borderCollapse: "collapse" }}>
          <thead style={{ backgroundColor: "#f2f2f2" }}>
            <tr>
              <th>ID</th>
              <th>Student ID</th>
              <th>Subject ID</th>
              <th>Grade</th>
              <th>Attendance %</th>
              <th>Remarks</th>
              <th>Edit</th>
            </tr>
          </thead>
          <tbody>
            {reports.map((r) => (
              <tr key={r.id}>
                <td>{r.id}</td>
                <td>{r.student_id}</td>
                <td>{r.grade}</td>
                <td>{r.attendancePercentage}</td>
                <td>{r.remarks}</td>
                <td>
                  <button onClick={() => editReport(r)}>Edit</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
