package com.cydeo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "COURSES")
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CATEGORY")
    private String category;
    private int rating;
    @Column(name = "DESCRIPTION")
    private String description;




}
