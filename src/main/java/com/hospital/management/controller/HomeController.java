package com.hospital.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "<h1>Hospital Management System - LIVE</h1><p>By Ayush Jain Roll No 105</p>";
    }
}
