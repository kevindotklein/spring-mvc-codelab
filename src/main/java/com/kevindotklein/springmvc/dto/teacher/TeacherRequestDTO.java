package com.kevindotklein.springmvc.dto.teacher;

import com.kevindotklein.springmvc.models.enums.TeacherStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;


import java.math.BigDecimal;

public record TeacherRequestDTO(@NotBlank @NotNull String name, @NotNull @DecimalMin(value = "0.0", inclusive = true) BigDecimal salary, TeacherStatus status) {
    public TeacherRequestDTO(String name, BigDecimal salary, TeacherStatus status) {
        this.name = name;
        this.salary = salary;
        this.status = status;
    }

}
