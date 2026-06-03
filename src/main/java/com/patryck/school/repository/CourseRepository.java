package com.patryck.school.repository;
import com.patryck.school.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByActive(Boolean active);
}
