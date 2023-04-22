package com.kevindotklein.springmvc.models;

import com.kevindotklein.springmvc.dto.course.CourseRequestDTO;
import com.kevindotklein.springmvc.models.enums.CourseType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private CourseType type;

    public Course(){}

    public Course(CourseRequestDTO data){
        this.name = data.name();
        this.description = data.description();
        this.type = data.type();
    }
}
