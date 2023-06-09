package com.kevindotklein.springmvc.services;

import com.kevindotklein.springmvc.exceptions.course.CourseDoesNotExistException;
import com.kevindotklein.springmvc.models.Course;
import com.kevindotklein.springmvc.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll(){
        return this.courseRepository.findAll();
    }

    public void save(Course course){
        this.courseRepository.save(course);
    }

    public Course findById(Long id){
        return this.courseRepository.findById(id).orElseThrow(() -> new CourseDoesNotExistException(id));
    }

    public boolean existsById(Long id){
        return this.courseRepository.existsById(id);
    }

    public void deleteById(Long id){
        this.courseRepository.deleteById(id);
    }
}
