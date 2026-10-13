package com.studentgrade.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "results")
public class Result {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "student_id") private Student student;
    @Column(nullable = false) private int totalMarks;
    @Column(nullable = false) private int maximumMarks;
    @Column(nullable = false) private double averagePercentage;
    @Column(nullable = false, length = 3) private String grade;
    @Column(nullable = false, length = 1000) private String feedback;
    @Column(nullable = false, updatable = false) private LocalDateTime createdAt;
    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL, orphanRemoval = true) private List<SubjectMark> subjects = new ArrayList<>();
    @PrePersist void onCreate(){this.createdAt=LocalDateTime.now();}
    public Long getId(){return id;} public Student getStudent(){return student;} public void setStudent(Student s){this.student=s;} public int getTotalMarks(){return totalMarks;} public void setTotalMarks(int v){this.totalMarks=v;}
    public int getMaximumMarks(){return maximumMarks;} public void setMaximumMarks(int v){this.maximumMarks=v;} public double getAveragePercentage(){return averagePercentage;} public void setAveragePercentage(double v){this.averagePercentage=v;}
    public String getGrade(){return grade;} public void setGrade(String v){this.grade=v;} public String getFeedback(){return feedback;} public void setFeedback(String v){this.feedback=v;} public LocalDateTime getCreatedAt(){return createdAt;} public List<SubjectMark> getSubjects(){return subjects;}
}