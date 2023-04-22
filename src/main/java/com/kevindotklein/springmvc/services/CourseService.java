package com.kevindotklein.springmvc.services;

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
}
