package com.studentgrade.repository;
import com.studentgrade.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ResultRepository extends JpaRepository<Result, Long> { List<Result> findByStudentIdOrderByCreatedAtDesc(Long studentId); }