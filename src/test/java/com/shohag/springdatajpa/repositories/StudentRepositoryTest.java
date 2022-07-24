package com.shohag.springdatajpa.repositories;

import com.shohag.springdatajpa.entities.Guardian;
import com.shohag.springdatajpa.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    // constructor injection throws error, why ? (should investigate)
//    public StudentRepositoryTest(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("sohag@gmail.com")
                .firstName("Sho")
                .lastName("hag")
                //.guardianName("ABC")
                //.guardianEmail("abc@gmail.com")
                //.guardianMobile("01955778899")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("DEF")
                .email("def@gmail.com")
                .mobile("01855667788")
                .build();

        Student student = Student.builder()
                .emailId("frustrated@gmail.com")
                .firstName("Frus")
                .lastName("trated")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void getStudentsByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Sho");
        System.out.println(students);
    }

    @Test
    public void findStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Sh");
        System.out.println(students);
    }

    @Test
    public void getStudentsHaveNotNullableLastNames() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println(students);
    }

    @Test
    public void findStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("DEF");
        System.out.println(students);
    }

    @Test
    public void findStudentByFirstNameAndLastName() {
        Student student = studentRepository.findByFirstNameAndLastName("Sho", "1");
        System.out.println(student);
    }
}