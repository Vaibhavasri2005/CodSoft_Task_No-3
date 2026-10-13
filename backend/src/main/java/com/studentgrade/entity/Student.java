package com.studentgrade.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = "roll_number"))
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name = "roll_number", nullable = false, unique = true) private String rollNumber;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private LocalDate dateOfBirth;
    @Column(nullable = false) private String password;
    @Column(nullable = false, updatable = false) private LocalDateTime createdAt;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true) private List<Result> results = new ArrayList<>();
    @PrePersist void onCreate() { this.createdAt = LocalDateTime.now(); }
    public Long getId(){return id;} public String getRollNumber(){return rollNumber;} public void setRollNumber(String v){this.rollNumber=v;}
    public String getName(){return name;} public void setName(String v){this.name=v;} public LocalDate getDateOfBirth(){return dateOfBirth;} public void setDateOfBirth(LocalDate v){this.dateOfBirth=v;}
    public String getPassword(){return password;} public void setPassword(String v){this.password=v;} public LocalDateTime getCreatedAt(){return createdAt;} public List<Result> getResults(){return results;}
}