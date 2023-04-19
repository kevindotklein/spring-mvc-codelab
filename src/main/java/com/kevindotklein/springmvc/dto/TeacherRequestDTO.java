package com.kevindotklein.springmvc.dto;

import com.kevindotklein.springmvc.models.enums.TeacherStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TeacherRequestDTO(@NotBlank @NotNull String name, @NotNull @DecimalMin(value = "0.0", inclusive = true) BigDecimal salary, TeacherStatus status) {
}
