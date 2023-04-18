package com.kevindotklein.springmvc.dto;

import com.kevindotklein.springmvc.models.enums.TeacherStatus;
import lombok.ToString;

import java.math.BigDecimal;

public record TeacherRequestDTO(String name, BigDecimal salary, TeacherStatus status) {
}
