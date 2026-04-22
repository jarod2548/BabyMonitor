package org.babymonitor.Course.repository;


import org.babymonitor.Course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
