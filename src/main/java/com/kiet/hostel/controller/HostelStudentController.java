package com.kiet.hostel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kiet.hostel.entity.HostelStudent;
import com.kiet.hostel.repository.HostelStudentRepository;

@RestController
@RequestMapping("/students")
public class HostelStudentController {

    @Autowired
    private HostelStudentRepository repository;

    // (b) Add student
    @PostMapping
    public ResponseEntity<HostelStudent> addStudent(@RequestBody HostelStudent student) {
        student.setId(0); // id auto-generate hogi
        HostelStudent saved = repository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // (c) Get all students
    @GetMapping
    public List<HostelStudent> getAllStudents() {
        return repository.findAll();
    }

    // (c) Get student by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        Optional<HostelStudent> student = repository.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Student with ID " + id + " not found");
    }

    // (d) Update hostel name, room number and fee
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id,
                                           @RequestBody HostelStudent updated) {
        Optional<HostelStudent> existing = repository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + id + " not found");
        }
        HostelStudent student = existing.get();
        student.setHostelName(updated.getHostelName());
        student.setRoomNumber(updated.getRoomNumber());
        student.setFee(updated.getFee());
        return ResponseEntity.ok(repository.save(student));
    }

    // (e) Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student with ID " + id + " not found");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Student with ID " + id + " deleted successfully");
    }
}