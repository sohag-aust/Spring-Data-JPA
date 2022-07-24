package com.shohag.springdatajpa.repositories;

import com.shohag.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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


    // Native Query
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1", // in native query we are searching based on table name on DB and table column names, here s is the instance, so s.email_address check the email_address property inside table column
            nativeQuery = true
    )
    Student getStudentByEmailIdUsingNativeQuery(String emailId);



    // Native Query using Named Params
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = :email",
            nativeQuery = true
    )
    Student getStudentByEmailIdUsingNativeQueryNamedParams(@Param("email") String emailId);


    // Check some update operations
    @Modifying // https://www.baeldung.com/spring-data-jpa-modifying-annotation
    @Transactional // important doc : https://stackoverflow.com/questions/1099025/spring-transactional-what-happens-in-background
    @Query(
            value = "UPDATE tbl_student s SET s.first_name = ?1 WHERE s.email_address = ?2", // this query will also work : UPDATE tbl_student SET first_name = ?1 WHERE email_address = ?2
            nativeQuery = true
    )
    void updateStudentNameByEmailId(String firstName, String emailId);
}
