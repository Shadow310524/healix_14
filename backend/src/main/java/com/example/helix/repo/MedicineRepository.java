    package com.example.helix.repo;

    import com.example.helix.entity.Medicine;
    import org.springframework.data.mongodb.repository.MongoRepository;

    import java.util.List;
    import java.util.Optional;

    public interface MedicineRepository extends MongoRepository<Medicine,String> {
        Optional<Medicine> findByName(String name);//exact match
    }
