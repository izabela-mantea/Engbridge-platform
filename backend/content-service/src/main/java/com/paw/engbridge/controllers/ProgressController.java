package com.paw.engbridge.controllers;

import com.paw.engbridge.model.UserProgress;
import com.paw.engbridge.services.ProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @PostMapping
    public ResponseEntity<UserProgress> saveProgress(@RequestBody UserProgress progressData) {
        if (progressData.getUserId() == null || progressData.getCourseId() == null) {
            return ResponseEntity.badRequest().build();
        }

        UserProgress saved = progressService.updateProgress(
                progressData.getUserId(),
                progressData.getCourseId(),
                progressData.getLevelId(),
                progressData.getScore(),
                progressData.getStatus()
        );
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserProgress>> getUserProgress(@PathVariable Integer userId) {
        return ResponseEntity.ok(progressService.getProgressForUser(userId));
    }

    @GetMapping("/user/{userId}/course/{courseId}")
    public ResponseEntity<UserProgress> getSpecificProgress(
            @PathVariable Integer userId,
            @PathVariable Integer courseId) {

        return progressService.getSpecificProgress(userId, courseId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}