import React, { useState } from "react";
import axios from "axios";

export default function ParentPage() {
  const [studentId, setStudentId] = useState("");
  const [reports, setReports] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const fetchReports = async () => {
    if (!studentId) {
      setError("Please enter a student ID");
      return;
    }
    setError("");
    setLoading(true);

    try {
      const res = await axios.get(`http://localhost:8010/reports/student/${studentId}`);
      setReports(res.data);
    } catch (err) {
      console.error("Error fetching reports:", err);
      setError("Could not fetch reports for this student ID");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Check Student Reports</h2>

      <div style={{ marginBottom: "20px" }}>
        <label>Enter Student ID: </label>
        <input
          type="number"
          value={studentId}
          onChange={(e) => setStudentId(e.target.value)}
        />
        <button onClick={fetchReports} style={{ marginLeft: "10px" }}>
          Get Reports
        </button>
      </div>

      {loading && <p>Loading reports...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}

      {reports.length > 0 && (
        <table border="1" style={{ width: "100%", textAlign: "left" }}>
          <thead>
            <tr>
              <th>Report ID</th>
              <th>Subject ID</th>
              <th>Grade</th>
              <th>Attendance (%)</th>
              <th>Remarks</th>
            </tr>
          </thead>
          <tbody>
            {reports.map((r) => (
              <tr key={r.id}>
                <td>{r.id}</td>
                <td>{r.subject_id}</td>
                <td>{r.grade}</td>
                <td>{r.attendancePercentage}%</td>
                <td>{r.remarks}</td>
                
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
