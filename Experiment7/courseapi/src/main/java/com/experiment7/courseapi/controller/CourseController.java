package com.experiment7.courseapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.experiment7.courseapi.entity.Course;
import com.experiment7.courseapi.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course c = service.addCourse(course);
        return ResponseEntity.status(201).body(c);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {

        Optional<Course> course = service.getCourseById(id);

        if(course.isPresent())
            return ResponseEntity.ok(course.get());
        else
            return ResponseEntity.status(404).body("Course Not Found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course){

        Optional<Course> c = service.getCourseById(id);

        if(c.isPresent()){
            course.setCourseId(id);
            return ResponseEntity.ok(service.updateCourse(course));
        }

        return ResponseEntity.status(404).body("Course Not Found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){

        Optional<Course> c = service.getCourseById(id);

        if(c.isPresent()){
            service.deleteCourse(id);
            return ResponseEntity.ok("Course Deleted");
        }

        return ResponseEntity.status(404).body("Course Not Found");
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title){
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}