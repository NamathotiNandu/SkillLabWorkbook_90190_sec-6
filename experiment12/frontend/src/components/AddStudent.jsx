import React, { useState } from "react";
import axios from "axios";
function AddStudent({ refreshStudents }) {
  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: ""
  });
  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("http://localhost:8080/students", student)
      .then(() => {
        alert("Student Added");
        refreshStudents();
        setStudent({ name:"", email:"", course:"" });
      });
  };
  return (
    <form onSubmit={handleSubmit}>
      <h2>Add Student</h2>
      <input
        type="text"
        name="name"
        placeholder="Name"
        value={student.name}
        onChange={handleChange}
      />
      <input
        type="email"
        name="email"
        placeholder="Email"
        value={student.email}
        onChange={handleChange}
      />
      <input
        type="text"
        name="course"
        placeholder="Course"
        value={student.course}
        onChange={handleChange}
      />
      <button type="submit">Add</button>
    </form>
  );
}
export default AddStudent;