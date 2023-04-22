package com.kevindotklein.springmvc.repositories;

import com.kevindotklein.springmvc.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
