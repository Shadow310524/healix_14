package com.example.helix.service;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.helix.entity.Medicine;
import com.example.helix.repo.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private MedicineRepository medicineRepository;
//    public void uploadImage(Medicine medicine, MultipartFile file) {
//        try {
//            if (file!=null && !file.isEmpty()) {
//                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
//                String imageUrl=uploadResult.get("secure_url").toString();
//                medicine.setImageUrls(List.of(imageUrl));
//                medicineRepository.save(medicine);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Image upload failed: " + e.getMessage());
//        }
//    }

//    CASE 1:WITH IMAGE
//public Medicine uploadImages(Medicine medicine, List<MultipartFile> files) {
//    try {
//        List<String> urls = new ArrayList<>();
//        for (MultipartFile file : files) {
//            if (file != null && !file.isEmpty()) {
//                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
//                urls.add(uploadResult.get("secure_url").toString());
//            }
//        }
//        medicine.setImageUrls(urls);
//        return medicineRepository.save(medicine);
//    } catch (IOException e) {
//        throw new RuntimeException("Image upload failed: " + e.getMessage());
//    }
//}


//    CASE 2:WITHOUT IMAGE
public Medicine uploadImages(Medicine medicine, List<MultipartFile> files) {
    List<String> urls = new ArrayList<>();
    if (files != null) {
        for (MultipartFile file : files) {
            if (file != null && !file.isEmpty()) {
                try {
                    Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                    urls.add(uploadResult.get("secure_url").toString());
                } catch (IOException e) {
                    throw new RuntimeException("Image upload failed: " + e.getMessage());
                }
            }
        }
    }

    medicine.setImageUrls(urls);
    return medicineRepository.save(medicine);
}


}
