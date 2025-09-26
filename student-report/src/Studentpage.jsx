import React, { useState } from "react";
import axios from "axios";

export default function StudentPage() {
  const [studentId, setStudentId] = useState("");     // Input for student ID
  const [reports, setReports] = useState([]);         // Fetched reports
  const [loading, setLoading] = useState(false);      // Loading indicator
  const [error, setError] = useState("");             // Error message

  // Fetch reports from backend
  const fetchReports = async () => {
    if (!studentId) {
      setError("Please enter your ID");
      setReports([]);
      return;
    }

    setError("");
    setLoading(true);

    try {
      const res = await axios.get(`http://localhost:8010/reports/student/${studentId}`);
      if (res.data && res.data.length > 0) {
        setReports(res.data);
      } else {
        setReports([]);
        setError("No reports found for this student ID");
      }
    } catch (err) {
      console.error("Error fetching reports:", err);
      setError("Server error or invalid student ID");
      setReports([]);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial, sans-serif" }}>
      <h2>Check Student Reports</h2>

      {/* Input for Student ID */}
      <div style={{ marginBottom: "20px" }}>
        <label>Enter Student ID: </label>
        <input
          type="number"
          value={studentId}
          onChange={(e) => setStudentId(e.target.value)}
          style={{ marginLeft: "10px", padding: "5px" }}
        />
        <button
          onClick={fetchReports}
          style={{ marginLeft: "10px", padding: "5px 10px" }}
        >
          Get Reports
        </button>
      </div>

      {/* Loading / Error */}
      {loading && <p>Loading reports...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}

      {/* Show reports if available */}
      {reports.length > 0 && (
        <table
          border="1"
          style={{
            width: "100%",
            textAlign: "left",
            borderCollapse: "collapse",
          }}
        >
          <thead style={{ backgroundColor: "#f2f2f2" }}>
            <tr>
              <th>ID</th>
              <th>Student Name</th>
              <th>Subject</th>
              <th>Grade</th>
              <th>Attendance (%)</th>
              <th>Remarks</th>
            </tr>
          </thead>
          <tbody>
            {reports.map((r) => (
              <tr key={r.id}>
                <td>{r.id}</td>
                <td>{r.student?.name || "N/A"}</td>
                <td>{r.subject?.name || "N/A"}</td>
                <td>{r.grade || "N/A"}</td>
                <td>{r.attendancePercentage ?? "N/A"}%</td>
                <td>{r.remarks || "N/A"}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
