package com.shohag.springdatajpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable // we don't want guardian as an entity, we want guardian class to be a part of Student. // docs: https://www.baeldung.com/jpa-embedded-embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({ // this annotation maps the table column of Student, which embed Guardian, with guardian property names and student table column name
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        )
})
@Builder
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
