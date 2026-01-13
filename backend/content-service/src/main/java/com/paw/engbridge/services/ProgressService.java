package com.paw.engbridge.services;

import com.paw.engbridge.model.Course;
import com.paw.engbridge.model.UserProgress;
import com.paw.engbridge.repositories.CourseRepository;
import com.paw.engbridge.repositories.UserProgressRepository;
import com.paw.engbridge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProgressService {

    private final UserProgressRepository progressRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProgressService(UserProgressRepository progressRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.progressRepository = progressRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
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

        UserProgress saved = progressRepository.save(progress);

        if ("COMPLETED".equalsIgnoreCase(status)) {
            checkAndUpgradeLevel(userId, levelId);
        }

        return saved;
    }

    private void checkAndUpgradeLevel(Integer userId, Integer levelId) {
        List<Course> allCoursesInLevel = courseRepository.findByLevelId(levelId);
        List<UserProgress> userProgressInLevel = progressRepository.findByUserId(userId)
                .stream()
                .filter(p -> p.getLevelId().equals(levelId) && "COMPLETED".equalsIgnoreCase(p.getStatus()))
                .toList();

        if (!allCoursesInLevel.isEmpty() && userProgressInLevel.size() >= allCoursesInLevel.size()) {
            userRepository.findById(userId).ifPresent(user -> {
                int currentMaxLevel = user.getLevels_id_lvl() != null ? user.getLevels_id_lvl() : 1;
                if (currentMaxLevel <= levelId && currentMaxLevel < 3) {
                    user.setLevels_id_lvl(levelId + 1);
                    userRepository.save(user);
                }
            });
        }
    }

    public List<UserProgress> getProgressForUser(Integer userId) {
        return progressRepository.findByUserId(userId);
    }

    public Optional<UserProgress> getSpecificProgress(Integer userId, Integer courseId) {
        return progressRepository.findByUserIdAndCourseId(userId, courseId);
    }
}