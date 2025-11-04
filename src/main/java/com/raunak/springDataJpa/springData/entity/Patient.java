package com.raunak.springDataJpa.springData.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Min(value = 0)
    @Max(value = 200, message = "Bed not available")
    @Column(unique = true)
    private int bedNo ;

    @NotBlank
    @Size(min = 3,max = 40,message = "Enter valid name")
    private String name;


    @NotBlank(message = "Email is mandatory")
    @Email(message = "Enter valid email")
    private String Email;
}
