package com.shohag.springdatajpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToOne
    @JoinColumn(
            name = "course_id", // this will be the column name inside course_material table for mapping course table
            referencedColumnName = "courseId" // it is the primary key inside course entity which is mapped with course_material entity
    )
    private Course course; // courseMaterial can't exists without a course
}
