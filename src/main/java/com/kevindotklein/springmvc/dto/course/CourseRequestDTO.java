package com.kevindotklein.springmvc.dto.course;

import com.kevindotklein.springmvc.models.enums.CourseType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRequestDTO(@NotNull @NotBlank String name, @NotNull @NotBlank String description, CourseType type) {
}
