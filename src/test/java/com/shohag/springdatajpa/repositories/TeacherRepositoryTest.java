package com.shohag.springdatajpa.repositories;

import com.shohag.springdatajpa.entities.Course;
import com.shohag.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDataStructure = Course.builder()
                .title("DataStructure")
                .credit(5)
                .build();

        Course algorithm = Course.builder()
                .title("Algorithm")
                .credit(8)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Mr.")
                .lastName("X")
                .courses(List.of(courseDataStructure, algorithm))
                .build();

        teacherRepository.save(teacher);
    }
}