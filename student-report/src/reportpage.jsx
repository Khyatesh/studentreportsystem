import React, { useEffect, useState } from "react";
import axios from "axios";

const ReportsPage = () => {
  const [reports, setReports] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8010/students")
      .then(res => setReports(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div>
      <h2>Reports</h2>
      <table border="1" style={{ width: "100%", textAlign: "left" }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Student ID</th>
            <th>Subject ID</th>
            <th>Grade</th>
            <th>Attendance (%)</th>
            <th>Remarks</th>
          </tr>
        </thead>
        <tbody>
          {reports.map(r => (
            <tr key={r.id}>
              <td>{r.id}</td>
              <td>{r.student_id}</td>
              <td>{r.subject_id}</td>
              <td>{r.grade}</td>
              <td>{r.attendance_percentage}</td>
              <td>{r.remarks}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ReportsPage;
