package com.shohag.springdatajpa.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL, // while creating courseMaterial without saving course earlier is failed, because there is no course in course table so referencing created problem, so here CASCADING comes into picture
            fetch = FetchType.LAZY,
            optional = false // it means, whenever we want to save a course, then it should have the course material details (means course material is required, so optional set to be false), by default optional is true
    )
    @JoinColumn(
            name = "course_id", // this will be the column name inside course_material table for mapping course table
            referencedColumnName = "courseId" // it is the primary key inside course entity which is mapped with course_material entity
    )
    private Course course; // courseMaterial can't exists without a course
}
