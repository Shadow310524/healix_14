//package com.example.helix.service;
//
//import com.example.helix.entity.Medicine;
//import com.example.helix.repo.MedicineRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class DataInitializationService implements CommandLineRunner {
//
//    @Autowired
//    private MedicineRepository medicineRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Check if data already exists
//            System.out.println(medicineRepository.count());
//        if (medicineRepository.count() ==13) {
//            System.out.println("Medicine data already exists. Skipping initialization.");
//            return;
//        }
//
//        System.out.println("Initializing medicine data...");
//
//        List<Medicine> medicines = Arrays.asList(
//            // Pain Relief Medicines
//            new Medicine(
//                "1", "Aspirin",
//                "Non-steroidal anti-inflammatory drug (NSAID) used to reduce pain, fever, and inflammation. Also used as an antiplatelet agent to prevent blood clots.",
//                "Pain Relief", "500mg",
//                Arrays.asList("https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=400"),
//                null, null, LocalDateTime.now(),
//                Arrays.asList("Headache", "Fever", "Muscle pain", "Arthritis", "Cardiovascular protection"),
//                Arrays.asList("Peptic ulcer", "Bleeding disorders", "Allergy to aspirin", "Children with viral infections"),
//                Arrays.asList("Stomach irritation", "Nausea", "Bleeding risk", "Ringing in ears"),
//                "Bayer Pharmaceuticals", 12.99,
//                Arrays.asList("Acetylsalicylic acid"),
//                "Store at room temperature, away from moisture",
//                "2025-12-31"
//            ),
//
//            new Medicine(
//                "2", "Ibuprofen",
//                "NSAID used to treat pain, fever, and inflammation. Effective for mild to moderate pain relief.",
//                "Pain Relief", "400mg",
//                Arrays.asList("https://images.unsplash.com/photo-1559757148-5c350d0d3c56?w=400"),
//                null, null, LocalDateTime.now(),
//                Arrays.asList("Headache", "Muscle pain", "Arthritis", "Menstrual cramps", "Dental pain"),
//                Arrays.asList("Peptic ulcer", "Severe heart failure", "Allergy to NSAIDs", "Third trimester pregnancy"),
//                Arrays.asList("Stomach upset", "Dizziness", "Headache", "Rash"),
//                "Pfizer", 8.50,
//                Arrays.asList("Ibuprofen"),
//                "Store at room temperature",
//                "2025-08-15"
//            ),
//
//            // Diabetes Medicines
//            new Medicine(
//                "3", "Metformin",
//                "First-line medication for type 2 diabetes. Improves insulin sensitivity and reduces glucose production in the liver.",
//                "Diabetes", "500mg",
//                Arrays.asList("https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=400"),
//                null, null, LocalDateTime.now(),
//                Arrays.asList("Type 2 diabetes", "Prediabetes", "Polycystic ovary syndrome"),
//                Arrays.asList("Severe kidney disease", "Liver disease", "Heart failure", "Contrast dye procedures"),
//                Arrays.asList("Nausea", "Diarrhea", "Metallic taste", "Vitamin B12 deficiency"),
//                "Merck & Co.", 25.50,
//                Arrays.asList("Metformin hydrochloride"),
//                "Store at room temperature",
//                "2025-06-30"
//            ),
//
//            new Medicine(
//                "4", "Insulin Glargine",
//                "Long-acting insulin analog used to control blood sugar levels in diabetes patients.",
//                "Diabetes", "100 units/ml",
//                Arrays.asList("https://images.unsplash.com/photo-1559757148-5c350d0d3c56?w=400"),
//                null, null, LocalDateTime.now(),
//                Arrays.asList("Type 1 diabetes", "Type 2 diabetes", "Diabetic ketoacidosis"),
//                Arrays.asList("Hypoglycemia", "Allergy to insulin"),
//                Arrays.asList("Hypoglycemia", "Weight gain", "Injection site reactions"),
//                "Sanofi", 45.75,
//                Arrays.asList("Insulin glargine"),
//                "Refrigerate, do not freeze",
//                "2025-03-20"
//            ),
//
//            // Cardiovascular Medicines
//            new Medicine(
//                "5", "Lisinopril",
//                "ACE inhibitor used to treat high blood pressure, heart failure, and to improve survival after heart attacks.",
//                "Cardiovascular", "10mg",
//                Arrays.asList("https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=400"),
//                null, null, LocalDateTime.now(),
//                Arrays.asList("Hypertension", "Heart failure", "Post-myocardial infarction", "Diabetic nephropathy"),
//                Arrays.asList("Pregnancy", "Bilateral renal artery stenosis", "History of angioedema"),
//                Arrays.asList("Dry cough", "Dizziness", "Fatigue", "Hyperkalemia"),
//                "AstraZeneca", 18.75,
//                Arrays.asList("Lisinopril"),
//                "Store at room temperature, protect from light",
//                "2025-09-15"
//            ),
//
//            new Medicine(
//                "6", "Atorvastatin",
//                "HMG-CoA reductase inhibitor (statin) used to lower cholesterol levels and reduce cardiovascular risk.",
//                "Cardiovascular", "20mg",
//                Arrays.asList("https://images.unsplash.com/photo-1559757148-5c350d0d3c56?w=400"),
//                null, null, LocalDateTime.now(),
//                Arrays.asList("Hypercholesterolemia", "Cardiovascular disease prevention", "Atherosclerosis"),
//                Arrays.asList("Active liver disease", "Pregnancy", "Breastfeeding"),
//                Arrays.asList("Muscle pain", "Liver enzyme elevation", "Digestive issues", "Memory problems"),
//                "Pfizer", 35.20,
//                Arrays.asList("Atorvastatin calcium"),
//                "Store at room temperature, protect from moisture",
//                "2025-11-20"
//            ),
//
//            // Gastrointestinal Medicines
//            new Medicine(
//                "7", "Omeprazole",
//                "Proton pump inhibitor used to reduce stomach acid production. Effective for treating acid-related conditions.",
//                "Gastrointestinal", "20mg",
//                Arrays.asList("https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=400"),
//                null, null, LocalDateTime.now(),
//                Arrays.asList("GERD", "Peptic ulcers", "Zollinger-Ellison syndrome", "NSAID-induced ulcers"),
//                Arrays.asList("Hypersensitivity to omeprazole", "Concurrent use with clopidogrel"),
//                Arrays.asList("Headache", "Nausea", "Diarrhea", "Vitamin B12 deficiency", "Increased fracture risk"),
//                "AstraZeneca", 22.80,
//                Arrays.asList("Omeprazole"),
//                "Store at room temperature, protect from light",
//                "2025-08-10"
//            ),
//
//            // Mental Health Medicines
//            new Medicine(
//                "8", "Sertraline",
//                "Selective serotonin reuptake inhibitor (SSRI) antidepressant used to treat depression, anxiety, and other mood disorders.",
//                "Mental Health", "50mg",
//                Arrays.asList("https://images.unsplash.com/photo-1559757148-5c350d0d3c56?w=400"),
//                null, null, LocalDateTime.now(),
//                Arrays.asList("Major depression", "Panic disorder", "Social anxiety", "PTSD", "OCD"),
//                Arrays.asList("MAOI use", "Pimozide use", "Severe liver disease"),
//                Arrays.asList("Nausea", "Insomnia", "Sexual dysfunction", "Weight changes", "Dry mouth"),
//                "Pfizer", 28.90,
//                Arrays.asList("Sertraline hydrochloride"),
//                "Store at room temperature",
//                "2025-07-25"
//            ),
//
//            // Respiratory Medicines
//            new Medicine(
//                "9", "Montelukast",
//                "Leukotriene receptor antagonist used to prevent asthma attacks and treat seasonal allergies.",
//                "Respiratory", "10mg",
//                Arrays.asList("https://images.unsplash.com/photo-1584308666744-24d5c474f2ae?w=400"),
//                null, null, LocalDateTime.now(),
//                Arrays.asList("Asthma prevention", "Seasonal allergic rhinitis", "Exercise-induced bronchoconstriction"),
//                Arrays.asList("Hypersensitivity to montelukast"),
//                Arrays.asList("Headache", "Abdominal pain", "Cough", "Dizziness", "Fatigue"),
//                "Merck & Co.", 32.40,
//                Arrays.asList("Montelukast sodium"),
//                "Store at room temperature",
//                "2025-05-18"
//            ),
//
//            // Endocrine Medicines
//            new Medicine(
//                "10", "Levothyroxine",
//                "Synthetic thyroid hormone used to treat hypothyroidism and thyroid cancer.",
//                "Endocrine", "75mcg",
//                Arrays.asList("https://images.unsplash.com/photo-1559757148-5c350d0d3c56?w=400"),
//                null, null, LocalDateTime.now(),
//                Arrays.asList("Hypothyroidism", "Thyroid cancer", "Goiter", "Thyroid nodules"),
//                Arrays.asList("Hyperthyroidism", "Adrenal insufficiency"),
//                Arrays.asList("Palpitations", "Weight loss", "Insomnia", "Anxiety", "Heat intolerance"),
//                "AbbVie", 19.95,
//                Arrays.asList("Levothyroxine sodium"),
//                "Store at room temperature, protect from light",
//                "2025-12-05"
//            )
//        );
//
//        medicineRepository.saveAll(medicines);
//        System.out.println("Successfully initialized " + medicines.size() + " medicines in the database.");
//    }
//}
