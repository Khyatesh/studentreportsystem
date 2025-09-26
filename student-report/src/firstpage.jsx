import { Link } from 'react-router-dom';
export default function FirstPage() {
    return (
        <div className="first-page">
            <h1>Welcome to Student report</h1>
            <Link to="/Studentlogin" className="link">Student</Link>
            <br/><br/>
            <Link to="/Parentlogin" className="link">Parent</Link>
            <br/><br/>
            <Link to="/Teacherlogin" className="link">Teacher</Link>
        </div>
    );
}