package com.shohag.springdatajpa.repositories;

import com.shohag.springdatajpa.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}
