package com.patryck.school.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name = "courses") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, unique = true) private String name;
    @Column(nullable = false) private String instructor;
    @Column(nullable = false) private Integer workload;
    @Column(nullable = false) private Integer maxStudents;
    @Builder.Default private Boolean active = true;
}
