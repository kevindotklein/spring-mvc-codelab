package com.kevindotklein.springmvc.repositories;

import com.kevindotklein.springmvc.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepositoy extends JpaRepository<Teacher, Long> {
}
