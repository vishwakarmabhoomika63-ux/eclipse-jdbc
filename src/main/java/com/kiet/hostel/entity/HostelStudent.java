package com.kiet.hostel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hostel_student")
public class HostelStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name", length = 100)
    private String studentName;

    @Column(name = "roll_number", length = 20)
    private String rollNumber;

    @Column(name = "hostel_name", length = 50)
    private String hostelName;

    @Column(name = "room_number", length = 20)
    private String roomNumber;

    private double fee;

    public HostelStudent() {
    }

    public HostelStudent(String studentName, String rollNumber, String hostelName,
                         String roomNumber, double fee) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.hostelName = hostelName;
        this.roomNumber = roomNumber;
        this.fee = fee;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public String getHostelName() { return hostelName; }
    public void setHostelName(String hostelName) { this.hostelName = hostelName; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }
}