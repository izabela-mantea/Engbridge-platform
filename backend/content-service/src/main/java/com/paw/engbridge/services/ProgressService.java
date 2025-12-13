package com.paw.engbridge.services;

import com.paw.engbridge.model.UserProgress;
import com.paw.engbridge.repositories.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProgressService {

    private final UserProgressRepository progressRepository;

    @Autowired
    public ProgressService(UserProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }
    public UserProgress updateProgress(Integer userId, Integer courseId, Integer levelId, BigDecimal score, String status) {
        Optional<UserProgress> existingProgress = progressRepository.findByUserIdAndCourseId(userId, courseId);

        UserProgress progress;
        if (existingProgress.isPresent()) {
            progress = existingProgress.get();
            progress.setScore(score);
            if (status != null) {
                progress.setStatus(status);
            }
        } else {
            progress = new UserProgress();
            progress.setUserId(userId);
            progress.setCourseId(courseId);
            progress.setLevelId(levelId);
            progress.setScore(score != null ? score : BigDecimal.ZERO);
            progress.setStatus(status != null ? status : "IN_PROGRESS");
        }

        return progressRepository.save(progress);
    }

    public List<UserProgress> getProgressForUser(Integer userId) {
        return progressRepository.findByUserId(userId);
    }

    public Optional<UserProgress> getSpecificProgress(Integer userId, Integer courseId) {
        return progressRepository.findByUserIdAndCourseId(userId, courseId);
    }
}