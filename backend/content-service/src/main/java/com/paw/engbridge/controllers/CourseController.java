package com.paw.engbridge.controllers;

import com.paw.engbridge.model.Course;
import com.paw.engbridge.model.Level;
import com.paw.engbridge.services.CourseService;
import com.paw.engbridge.services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final LevelService levelService;

    public CourseController(CourseService courseService, LevelService levelService) {
        this.courseService = courseService;
        this.levelService = levelService;
    }
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.findAll();
        return ResponseEntity.ok(courses);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id) {
        return courseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        if (course.getLevel() == null || course.getLevel().getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Level level = levelService.findById(course.getLevel().getId())
                .orElseThrow(() -> new RuntimeException("Level not found with id: " + course.getLevel().getId()));

        course.setLevel(level);

        Course savedCourse = courseService.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        return courseService.findById(id)
                .map(course -> {
                    courseService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

