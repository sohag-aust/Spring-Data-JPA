package com.shohag.springdatajpa.repositories;

import com.shohag.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // creating custom JPA queries : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
    // Supported keywords inside method names : https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    // JPQL : https://www.baeldung.com/jpql-hql-criteria-query

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName); // findBy ta first e dibo, then guardian ta student er property tai guardian dibo, then guardian er property holo name tai name dibo.
    Student findByFirstNameAndLastName(String firstName, String lastName);


    // creating JPQL queries using @Query annotation
    // JPQL works based on Class of the Entity and properties of that entity class, it not works based on Entity table inside DB
    @Query("SELECT s FROM Student s where s.emailId = ?1") // here s is the object of student class, and we are accessing email property of object s, and here ?1 is the first param of parameter list
    Student getStudentByEmailId(String emailId);

    @Query("SELECT s.firstName FROM Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String emailId);
}
