package com.patryck.school.controller;
import com.patryck.school.entity.*;
import com.patryck.school.repository.StudentRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/students") @RequiredArgsConstructor
@Tag(name = "Alunos", description = "Gestão de alunos")
public class StudentController {
    private final StudentRepository studentRepository;
    @PostMapping public ResponseEntity<Student> create(@Valid @RequestBody Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(student));
    }
    @GetMapping public ResponseEntity<List<Student>> findAll() { return ResponseEntity.ok(studentRepository.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Student> findById(@PathVariable Long id) { return studentRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/search") public ResponseEntity<List<Student>> search(@RequestParam String name) { return ResponseEntity.ok(studentRepository.findByNameContainingIgnoreCase(name)); }
    @GetMapping("/status/{status}") public ResponseEntity<List<Student>> byStatus(@PathVariable StudentStatus status) { return ResponseEntity.ok(studentRepository.findByStatus(status)); }
    @PutMapping("/{id}") public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody Student updated) {
        return studentRepository.findById(id).map(s -> { updated.setId(id); return ResponseEntity.ok(studentRepository.save(updated)); }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { if (!studentRepository.existsById(id)) return ResponseEntity.notFound().build(); studentRepository.deleteById(id); return ResponseEntity.noContent().build(); }
}
