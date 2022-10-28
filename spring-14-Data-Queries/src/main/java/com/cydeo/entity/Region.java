package com.cydeo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@NoArgsConstructor
public class Region extends BaseEntity{

    private String region;
    private String country;

}
