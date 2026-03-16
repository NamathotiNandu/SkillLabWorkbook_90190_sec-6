package com.example.studentcrud.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;
    public List<Student> getAllStudents(){
        return repo.findAll();
    }
    public Student addStudent(Student s){
        return repo.save(s);
    }
    public Student updateStudent(Long id, Student s){
        Student existing = repo.findById(id).orElse(null);
        if(existing != null){
            existing.setName(s.getName());
            existing.setEmail(s.getEmail());
            existing.setCourse(s.getCourse());
            return repo.save(existing);
        }
        return null;
    }
    public void deleteStudent(Long id){
        repo.deleteById(id);
    }
}