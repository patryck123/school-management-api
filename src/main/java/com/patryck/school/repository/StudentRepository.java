package com.patryck.school.repository;
import com.patryck.school.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);
    Optional<Student> findByRegistration(String registration);
    List<Student> findByStatus(StudentStatus status);
    List<Student> findByNameContainingIgnoreCase(String name);
}
