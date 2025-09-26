import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { BrowserRouter, Routes,Route } from 'react-router-dom'
import FirstPage from './firstpage.jsx'
import Studentlogin from './Studentlogin.jsx'
import Parentlogin from './Parentlogin.jsx'
import Teacherlogin from './teacherlogin.jsx'
import TeacherPage from './Teacherpage.jsx'
import ParentPage from './ParentPage.jsx'
import StudentPage from './Studentpage.jsx'
createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<FirstPage/>} />
      <Route path="/Parentlogin" element={<Parentlogin/>} />
      <Route path="/Studentlogin" element={<Studentlogin/>} />
      <Route path="/teacherlogin" element={<Teacherlogin/>}/>
      <Route path="/TeacherPage" element={<TeacherPage/>}/>
      <Route path="/ParentPage" element={<ParentPage/>}/>
      <Route path="/StudentPage" element={<StudentPage/>}/>
    </Routes>
  </BrowserRouter>
)
