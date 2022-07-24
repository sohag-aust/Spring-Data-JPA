package com.shohag.springdatajpa.repositories;

import com.shohag.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
