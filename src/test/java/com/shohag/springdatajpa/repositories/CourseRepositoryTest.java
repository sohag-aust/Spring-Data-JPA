package com.shohag.springdatajpa.repositories;

import com.shohag.springdatajpa.entities.Course;
import com.shohag.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("ABC")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(12)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}