package com.kiet.hostel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kiet.hostel.entity.HostelStudent;

public interface HostelStudentRepository extends JpaRepository<HostelStudent, Integer> {
}