package com.kevindotklein.springmvc.controllers;

import com.kevindotklein.springmvc.models.Teacher;
import com.kevindotklein.springmvc.models.enums.TeacherStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @GetMapping
    public ModelAndView getAll(){
        Teacher t = new Teacher();
        t.setId(1L);
        t.setName("Test");
        t.setSalary(BigDecimal.valueOf(8000.0));
        t.setStatus(TeacherStatus.ACTIVE);
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(t);
        ModelAndView mv = new ModelAndView("teachers/index");
        mv.addObject("teachers", teacherList);
        return mv;
    }
}
