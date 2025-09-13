package com.example.helix.controller;

import com.example.helix.entity.Medicine;
import com.example.helix.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharma")
//@CrossOrigin(origins = {"http://localhost:50513", "http://127.0.0.1:50513"})
public class MedicineController {

    @Autowired
    private MedicineService medservice;

    @PostMapping("/add")
    public Medicine addMedicine(@RequestBody Medicine medicine){
        System.out.println("Adding new medicine: " + medicine.getName());
        return medservice.addMedicine(medicine);
    }

    @PostMapping("/add/bulk")
    public ResponseEntity<List<Medicine>> addMedicinesBulk(@RequestBody List<Medicine> medicines){
        System.out.println("Adding " + medicines.size() + " medicines in bulk");
        List<Medicine> savedMedicines = medservice.addMedicinesBulk(medicines);
        return ResponseEntity.ok(savedMedicines);
    }

    @GetMapping("/get/search/{name}")
    public ResponseEntity<Medicine> getByName(@PathVariable String name){
        Medicine medicine=medservice.getByName(name);
        return ResponseEntity.ok(medicine);
    }

    @GetMapping("/get")
    public List<Medicine> getMedicine(){
        return medservice.getMedicine();
    }
    @GetMapping("/get/{id}")
   public Medicine getMedicineById(@PathVariable String id){
        System.out.println(id);
        return medservice.getById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteMedicinebyId(@PathVariable String id){
        return medservice.deleteById(id);
    }
//Put->Overwrite everything
//Patch->Partially Overwrite
    @PatchMapping("/update")
    public String updateMedicineById(@RequestBody Medicine updateMedicine){
        return medservice.updateById(updateMedicine.getId(),updateMedicine);
    }
}
