package com.kevindotklein.springmvc.controllers;

import com.kevindotklein.springmvc.dto.TeacherRequestDTO;
import com.kevindotklein.springmvc.models.Teacher;
import com.kevindotklein.springmvc.models.enums.TeacherStatus;
import com.kevindotklein.springmvc.services.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView getNewTeacher(TeacherRequestDTO data){
        ModelAndView mv = new ModelAndView("teachers/new");
        mv.addObject("teacherStatus", TeacherStatus.values());
        return mv;
    }

    @PostMapping
    public ModelAndView postNewTeacher(@Valid TeacherRequestDTO data, BindingResult result){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("/teachers/new");
            mv.addObject("teacherStatus", TeacherStatus.values());
            return mv;
        }
        Teacher teacher = new Teacher(data);
        this.teacherService.save(teacher);
        return new ModelAndView("redirect:/teachers/"+teacher.getId());
    }

    @GetMapping("/{id}")
    public ModelAndView getTeacherDetails(@PathVariable Long id){
        Teacher teacher = this.teacherService.findById(id);
        ModelAndView mv = new ModelAndView("teachers/details");
        mv.addObject("teacher", teacher);
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView getEditTeacher(@PathVariable Long id, TeacherRequestDTO data){
        Teacher teacher = this.teacherService.findById(id);
        ModelAndView mv = new ModelAndView("teachers/edit");
        mv.addObject("teacherStatus", TeacherStatus.values());
        mv.addObject("teacher", teacher);
        return mv;
    }

    @PostMapping("/{id}")
    public ModelAndView updateTeacher(@PathVariable Long id, @Valid TeacherRequestDTO data, BindingResult result){
        Teacher teacher = this.teacherService.findById(id);
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("teachers/edit");
            mv.addObject("teacherStatus", TeacherStatus.values());
            mv.addObject("teacher", teacher);
            return mv;
        }
        teacher.updateAllAttributes(data.name(), data.salary(), data.status());
        this.teacherService.save(teacher);
        ModelAndView mv = new ModelAndView("redirect:/teachers/"+id);
        return mv;
    }

}
