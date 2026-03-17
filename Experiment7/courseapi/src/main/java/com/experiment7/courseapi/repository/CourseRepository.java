package com.experiment7.courseapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.experiment7.courseapi.entity.Course;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByTitleContaining(String title);

}