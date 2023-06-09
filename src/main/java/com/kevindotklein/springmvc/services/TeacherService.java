package com.kevindotklein.springmvc.services;

import com.kevindotklein.springmvc.exceptions.teacher.TeacherDoesNotExistException;
import com.kevindotklein.springmvc.models.Teacher;
import com.kevindotklein.springmvc.repositories.TeacherRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepositoy teacherRepositoy;

    public List<Teacher> findAll(){
        return this.teacherRepositoy.findAll();
    }

    public void save(Teacher teacher){
        this.teacherRepositoy.save(teacher);
    }

    public Teacher findById(Long id){
        return this.teacherRepositoy.findById(id).orElseThrow(() -> new TeacherDoesNotExistException(id));
    }

    public void deleteById(Long id){
        this.teacherRepositoy.deleteById(id);
    }

    public boolean existsById(Long id){
        return this.teacherRepositoy.existsById(id);
    }
}
