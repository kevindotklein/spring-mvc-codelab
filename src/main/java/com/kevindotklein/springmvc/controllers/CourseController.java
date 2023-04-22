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
import org.springframework.web.bind.annotation.PathVariable;
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
        return new ModelAndView("redirect:/courses/"+course.getId());
    }

    @GetMapping("/{id}")
    public ModelAndView getCourseDetails(@PathVariable Long id){
        Course course = this.courseService.findById(id);
        ModelAndView mv = new ModelAndView("courses/details");
        mv.addObject("course", course);
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getCourseEdit(@PathVariable Long id, CourseRequestDTO data){
        Course course = this.courseService.findById(id);
        ModelAndView mv = new ModelAndView("courses/edit");
        mv.addObject("courseType", CourseType.values());
        mv.addObject("course", course);
        return mv;
    }

    @PostMapping("/{id}")
    public ModelAndView updateCourse(@PathVariable Long id, @Valid CourseRequestDTO data, BindingResult result){
        Course course = this.courseService.findById(id);
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("courses/edit");
            mv.addObject("courseType", CourseType.values());
            mv.addObject("course", course);
            return mv;
        }

        course.updateAllAttributes(data.name(), data.description(), data.type());
        this.courseService.save(course);
        ModelAndView mv;
        mv = this.courseSuccessMessage("redirect:/courses/"+id, "Curso #"+id+" atualizado com sucesso");
        return mv;
    }

    public ModelAndView courseErrorMessage(String route, String message){
        ModelAndView mv = new ModelAndView(route);
        mv.addObject("message", message);
        mv.addObject("error", true);
        return mv;
    }

    public ModelAndView courseSuccessMessage(String route, String message){
        ModelAndView mv = new ModelAndView(route);
        mv.addObject("message", message);
        mv.addObject("error", false);
        return mv;
    }
}
