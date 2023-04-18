package com.kevindotklein.springmvc.controllers;

import com.kevindotklein.springmvc.dto.TeacherRequestDTO;
import com.kevindotklein.springmvc.models.Teacher;
import com.kevindotklein.springmvc.models.enums.TeacherStatus;
import com.kevindotklein.springmvc.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ModelAndView getAll(){
        List<Teacher> teacherList = this.teacherService.findAll();
        ModelAndView mv = new ModelAndView("teachers/index");
        mv.addObject("teachers", teacherList);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView getNewTeacher(){
        ModelAndView mv = new ModelAndView("teachers/new");
        mv.addObject("teacherStatus", TeacherStatus.values());
        return mv;
    }

    @PostMapping
    public String postNewTeacher(TeacherRequestDTO data){
        Teacher teacher = new Teacher(data);
        this.teacherService.save(teacher);
        return "redirect:/teachers";
    }
}
