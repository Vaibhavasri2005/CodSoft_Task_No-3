package com.studentgrade.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public final class AuthDtos {
    private AuthDtos() {}
    public record RegisterRequest(@NotBlank String name, @NotBlank String rollNumber, @NotNull @Past LocalDate dateOfBirth, @NotBlank @Size(min=8) String password) {}
    public record LoginRequest(@NotBlank String rollNumber, @NotNull LocalDate dateOfBirth, @NotBlank String password) {}
    public record AuthResponse(String token, StudentResponse student) {}
    public record StudentResponse(Long id, String name, String rollNumber, LocalDate dateOfBirth, LocalDateTime createdAt) {}
    public record MessageResponse(boolean success, String message) {}
    public record SubjectRequest(@NotBlank String subjectName, @NotNull @Min(0) @Max(100) Integer marks) {}
    public record ResultRequest(@NotEmpty List<SubjectRequest> subjects) {}
    public record SubjectResponse(String subjectName, int marks) {}
    public record ResultResponse(Long id, String studentName, String rollNumber, int totalMarks, int maximumMarks, double averagePercentage, String grade, String performanceStatus, String feedback, String strongestSubject, String improvementSubject, long subjectsAbove80, long subjectsBelow50, List<SubjectResponse> subjects, LocalDateTime createdAt) {}
}