package com.kevindotklein.springmvc.models;

import com.kevindotklein.springmvc.dto.TeacherRequestDTO;
import com.kevindotklein.springmvc.models.enums.TeacherStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private BigDecimal salary;
    @Enumerated(EnumType.STRING)
    private TeacherStatus status;

    public Teacher() {}

    public Teacher(TeacherRequestDTO data){
        this.name = data.name();
        this.salary = data.salary();
        this.status = data.status();
    }
}
