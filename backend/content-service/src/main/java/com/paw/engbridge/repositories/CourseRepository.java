package com.paw.engbridge.repositories;

import com.paw.engbridge.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByLevelId(Integer levelId);

    List<Course> findAllByOrderByOrderNumAsc();
}

