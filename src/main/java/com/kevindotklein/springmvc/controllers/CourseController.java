package com.kevindotklein.springmvc.controllers;

import com.kevindotklein.springmvc.dto.course.CourseRequestDTO;
import com.kevindotklein.springmvc.models.Course;
import com.kevindotklein.springmvc.models.enums.CourseType;
import com.kevindotklein.springmvc.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ModelAndView getAll(){
        List<Course> courseList = this.courseService.findAll();
        ModelAndView mv = new ModelAndView("courses/index");
        mv.addObject("courses", courseList);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView getNewCourse(CourseRequestDTO data){
        Course course = new Course(data);
        ModelAndView mv = new ModelAndView("courses/new");
        mv.addObject("courseType", CourseType.values());
        mv.addObject("course", course);
        return mv;
    }

    @PostMapping
    public ModelAndView postNewCourse(@Valid CourseRequestDTO data, BindingResult result){
        Course course = new Course(data);
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("courses/new");
            mv.addObject("courseType", CourseType.values());
            mv.addObject("course", course);
            return mv;
        }

        this.courseService.save(course);
        return new ModelAndView("redirect:/courses");
    }
}
