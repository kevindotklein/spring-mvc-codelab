package com.kevindotklein.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", "kevin");
        return mv;
    }
}
