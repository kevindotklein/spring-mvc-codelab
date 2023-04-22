package com.kevindotklein.springmvc.exceptions.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CourseDoesNotExistException extends RuntimeException{
    public CourseDoesNotExistException(Long id){
        super("Course: "+id+" does not exist");
    }
}
