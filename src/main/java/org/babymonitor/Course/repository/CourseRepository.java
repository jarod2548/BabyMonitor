package org.babymonitor.Course.repository;

import org.babymonitor.Course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCompleet(boolean isCompleet);
}
