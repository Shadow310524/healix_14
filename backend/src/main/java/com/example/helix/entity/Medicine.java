package com.example.helix.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "medicines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
    @Id
    private String id;
    private String name;
    private String description;
    private String category;
    private String dosage;
    private List<String> imageUrls;
    private String pdfUrl;
    private String videoUrl;
    private LocalDateTime createdAt;
    
    // Additional medical information fields
    private List<String> indications;
    private List<String> contraindications;
    private List<String> sideEffects;
    private String manufacturer;
    private Double price;
    private List<String> ingredients;
    private String storageConditions;
    private String expiryDate;
}
