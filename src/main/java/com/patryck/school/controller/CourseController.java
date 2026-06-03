package com.patryck.school.controller;
import com.patryck.school.entity.Course;
import com.patryck.school.repository.CourseRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/courses") @RequiredArgsConstructor
@Tag(name = "Cursos", description = "Gestão de cursos")
public class CourseController {
    private final CourseRepository courseRepository;
    @PostMapping public ResponseEntity<Course> create(@RequestBody Course course) { return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course)); }
    @GetMapping public ResponseEntity<List<Course>> findAll() { return ResponseEntity.ok(courseRepository.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Course> findById(@PathVariable Long id) { return courseRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/active") public ResponseEntity<List<Course>> findActive() { return ResponseEntity.ok(courseRepository.findByActive(true)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { courseRepository.deleteById(id); return ResponseEntity.noContent().build(); }
}
