package com.shohag.springdatajpa.repositories;

import com.shohag.springdatajpa.entities.Course;
import com.shohag.springdatajpa.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);

        // while creating courseMaterial without saving course earlier is failed, because there is no course in course table so referencing created problem, so here CASCADING comes into picture
    }

    @Test
    public void getAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);

        // courseMaterial entity is the parent of course entity, so as we describe fetchType as lazy, so pulling course material not pull course along with
    }
}