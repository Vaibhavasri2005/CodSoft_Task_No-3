package com.studentgrade.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subject_marks")
public class SubjectMark {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "result_id") private Result result;
    @Column(nullable = false) private String subjectName;
    @Column(nullable = false) private int marks;
    public Long getId(){return id;} public Result getResult(){return result;} public void setResult(Result v){this.result=v;} public String getSubjectName(){return subjectName;} public void setSubjectName(String v){this.subjectName=v;} public int getMarks(){return marks;} public void setMarks(int v){this.marks=v;}
}