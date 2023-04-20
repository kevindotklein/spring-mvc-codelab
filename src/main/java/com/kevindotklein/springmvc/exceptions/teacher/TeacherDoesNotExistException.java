package com.kevindotklein.springmvc.exceptions.teacher;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class TeacherDoesNotExistException extends RuntimeException{
    public TeacherDoesNotExistException(Long id){
        super("Teacher: "+id+" does not exist");
    }
}
