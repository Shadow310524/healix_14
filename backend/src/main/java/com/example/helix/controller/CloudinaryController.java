package com.example.helix.controller;

import com.example.helix.entity.Medicine;
import com.example.helix.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/pharma")
public class CloudinaryController {
    @Autowired
    private CloudinaryService cloudinaryService;
    @PostMapping("/upload")
    public ResponseEntity<Medicine> uploadfile(@RequestPart("medicine") Medicine medicine, @RequestPart(value = "files", required = false) List<MultipartFile> files){
        if (files == null) {
            files = List.of(); // empty list if no images
        }
        System.out.println("Received medicine: " + medicine);
        Medicine savedMedicine=cloudinaryService.uploadImages(medicine, files);
        return ResponseEntity.ok(savedMedicine);
    }
}
