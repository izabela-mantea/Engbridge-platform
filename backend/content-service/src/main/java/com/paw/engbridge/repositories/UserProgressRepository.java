package com.paw.engbridge.repositories;

import com.paw.engbridge.model.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress, Integer> {

    Optional<UserProgress> findByUserIdAndCourseId(Integer userId, Integer courseId);

    List<UserProgress> findByUserId(Integer userId);
}