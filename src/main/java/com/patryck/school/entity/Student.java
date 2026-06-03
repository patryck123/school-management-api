package com.patryck.school.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity @Table(name = "students") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @NotBlank @Column(nullable = false) private String name;
    @Email @Column(nullable = false, unique = true) private String email;
    @Column(unique = true) private String registration;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING) @Builder.Default private StudentStatus status = StudentStatus.ACTIVE;
    @Column(nullable = false, updatable = false) private LocalDateTime enrolledAt;
    @PrePersist protected void onCreate() {
        enrolledAt = LocalDateTime.now();
        registration = "MAT" + System.currentTimeMillis();
    }
}
