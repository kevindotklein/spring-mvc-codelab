package com.kevindotklein.springmvc.dto;

import com.kevindotklein.springmvc.models.enums.TeacherStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.ToString;

import java.math.BigDecimal;

public record TeacherRequestDTO(@NotBlank @NonNull String name, @DecimalMin(value = "0", inclusive = true) @NotNull BigDecimal salary, TeacherStatus status) {
}
