package com.example.helix.service;

import com.example.helix.entity.Medicine;
import com.example.helix.repo.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medrepo;

    public Medicine addMedicine(Medicine medicine){
        medicine.setCreatedAt(java.time.LocalDateTime.now());
        return medrepo.save(medicine);
    }

    public List<Medicine> addMedicinesBulk(List<Medicine> medicines){
        medicines.forEach(medicine -> {
            if (medicine.getCreatedAt() == null) {
                medicine.setCreatedAt(java.time.LocalDateTime.now());
            }
        });
        return medrepo.saveAll(medicines);
    }

    public List<Medicine> getMedicine() {
        return medrepo.findAll();
    }

    public Medicine getById(String id) {
        return medrepo.findById(id).orElseThrow(() -> new RuntimeException("Id not found!!->"+id));
    }

    public String deleteById(String id) {
        if(medrepo.existsById(id)) {
            medrepo.deleteById(id);
            return "Succesfully Deleted!!";
        }
        return "Id not found!!";
    }

    public String updateById(String id,Medicine updatedFields) {
        Medicine existing=medrepo.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
        if (updatedFields.getName() != null) {
            existing.setName(updatedFields.getName());
        }
        if (updatedFields.getDescription() != null) {
            existing.setDescription(updatedFields.getDescription());
        }
        if (updatedFields.getCategory() != null) {
            existing.setCategory(updatedFields.getCategory());
        }
        if (updatedFields.getDosage() != null) {
            existing.setDosage(updatedFields.getDosage());
        }
        if (updatedFields.getImageUrls() != null) {
            existing.setImageUrls(updatedFields.getImageUrls());
        }
        if (updatedFields.getPdfUrl() != null) {
            existing.setPdfUrl(updatedFields.getPdfUrl());
        }
        if (updatedFields.getVideoUrl() != null) {
            existing.setVideoUrl(updatedFields.getVideoUrl());
        }
        if (updatedFields.getIndications() != null) {
            existing.setIndications(updatedFields.getIndications());
        }
        if (updatedFields.getContraindications() != null) {
            existing.setContraindications(updatedFields.getContraindications());
        }
        if (updatedFields.getSideEffects() != null) {
            existing.setSideEffects(updatedFields.getSideEffects());
        }
        if (updatedFields.getManufacturer() != null) {
            existing.setManufacturer(updatedFields.getManufacturer());
        }
        if (updatedFields.getPrice() != null) {
            existing.setPrice(updatedFields.getPrice());
        }
        if (updatedFields.getIngredients() != null) {
            existing.setIngredients(updatedFields.getIngredients());
        }
        if (updatedFields.getStorageConditions() != null) {
            existing.setStorageConditions(updatedFields.getStorageConditions());
        }
        if (updatedFields.getExpiryDate() != null) {
            existing.setExpiryDate(updatedFields.getExpiryDate());
        }
        medrepo.save(existing);
        return "Succesfully Updated";
    }

    public Medicine getByName(String name){
        return medrepo.findByName(name).orElseThrow(()->new RuntimeException("No name found!!"));
    }
}
