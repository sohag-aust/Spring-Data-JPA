package com.shohag.springdatajpa.repositories;

import com.shohag.springdatajpa.entities.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


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
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithThreeRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("Courses : " + courses);
        System.out.println("Total Elements : " + totalElements);
        System.out.println("Total Pages : " + totalPages);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> coursesSortByTitle = courseRepository.findAll(sortByTitle).getContent();
        List<Course> coursesSortByCreditDesc = courseRepository.findAll(sortByCreditDesc).getContent();
        List<Course> coursesSortByTitleAndCreditDesc = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

        System.out.println("coursesSortByTitle : " + coursesSortByTitle);
        System.out.println("coursesSortByCreditDesc : " + coursesSortByCreditDesc);
        System.out.println("coursesSortByTitleAndCreditDesc : " + coursesSortByTitleAndCreditDesc);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
        System.out.println("courses : " + courses);
    }
}