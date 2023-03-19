package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_updated")
    private Date dateUpdated;

    @Column(name = "status")
    private Integer status;

//    @OneToMany(mappedBy = "position",fetch = FetchType.EAGER)
//    private Set<Staff> listStaffs;
}
