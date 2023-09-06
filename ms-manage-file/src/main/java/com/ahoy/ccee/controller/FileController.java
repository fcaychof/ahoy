package com.ahoy.ccee.controller;

import com.ahoy.ccee.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin()
@RequiredArgsConstructor
public class FileController {

    private final FileService service;

    @GetMapping("/file")
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
}
