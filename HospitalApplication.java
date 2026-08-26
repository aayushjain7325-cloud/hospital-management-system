package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
@RestController
@CrossOrigin
public class HospitalApplication {

    private List<Map<String, String>> patients = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @GetMapping("/api/patients")
    public List<Map<String, String>> getPatients() {
        return patients;
    }

    @PostMapping("/api/patients")
    public Map<String, String> addPatient(@RequestBody Map<String, String> patient) {
        patient.put("id", UUID.randomUUID().toString());
        patients.add(patient);
        return patient;
    }

    @GetMapping("/")
    public String home() {
        return "Hospital Management System API is Running! - Ayush Jain Roll 105";
    }
}
