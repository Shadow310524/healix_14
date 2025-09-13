# Adding Medicines to Healix Backend

## Overview
Your Healix backend now supports comprehensive medicine data with detailed medical information. The system automatically initializes with 10 sample medicines when you first start the application.

## Medicine Data Structure

Each medicine now includes:
- **Basic Info**: Name, description, category, dosage
- **Medical Details**: Indications, contraindications, side effects
- **Commercial Info**: Manufacturer, price
- **Technical Info**: Active ingredients, storage conditions, expiry date
- **Media**: Image URLs, PDF documents, videos

## Adding New Medicines

### Method 1: Using the REST API

#### Add Single Medicine
```bash
POST http://localhost:8080/pharma/add
Content-Type: application/json

{
  "name": "New Medicine Name",
  "description": "Detailed description of the medicine",
  "category": "Pain Relief",
  "dosage": "500mg",
  "imageUrls": ["https://example.com/image.jpg"],
  "indications": ["Headache", "Fever"],
  "contraindications": ["Allergy to medicine"],
  "sideEffects": ["Nausea", "Dizziness"],
  "manufacturer": "Pharmaceutical Company",
  "price": 25.99,
  "ingredients": ["Active Ingredient"],
  "storageConditions": "Store at room temperature",
  "expiryDate": "2025-12-31"
}
```

#### Add Multiple Medicines (Bulk)
```bash
POST http://localhost:8080/pharma/add/bulk
Content-Type: application/json

[
  {
    "name": "Medicine 1",
    "description": "Description 1",
    "category": "Category 1",
    "dosage": "100mg",
    "manufacturer": "Company 1",
    "price": 15.99
  },
  {
    "name": "Medicine 2",
    "description": "Description 2",
    "category": "Category 2",
    "dosage": "200mg",
    "manufacturer": "Company 2",
    "price": 29.99
  }
]
```

### Method 2: Using the JSON File

1. Use the provided `additional_medicines.json` file
2. Send a POST request to `/pharma/add/bulk` with the JSON content
3. Or modify the `DataInitializationService.java` to include your medicines

### Method 3: Direct Database Insertion

You can also add medicines directly to MongoDB using any MongoDB client or the MongoDB Compass tool.

## Available Categories

The system supports these medicine categories:
- Pain Relief
- Diabetes
- Cardiovascular
- Gastrointestinal
- Mental Health
- Respiratory
- Endocrine
- Antibiotic

## Testing the API

### Get All Medicines
```bash
GET http://localhost:8080/pharma/get
```

### Search Medicine by Name
```bash
GET http://localhost:8080/pharma/get/search/Aspirin
```

### Get Medicine by ID
```bash
GET http://localhost:8080/pharma/get/{id}
```

### Update Medicine
```bash
PATCH http://localhost:8080/pharma/update
Content-Type: application/json

{
  "id": "medicine_id",
  "name": "Updated Name",
  "price": 30.99
}
```

### Delete Medicine
```bash
DELETE http://localhost:8080/pharma/delete/{id}
```

## Frontend Integration

The frontend will automatically:
- Load all medicines from the backend
- Display them in a responsive grid
- Allow searching and filtering by category
- Show detailed medical information
- Handle all CRUD operations

## Sample Data

The system comes with 10 pre-loaded medicines:
1. Aspirin (Pain Relief)
2. Ibuprofen (Pain Relief)
3. Metformin (Diabetes)
4. Insulin Glargine (Diabetes)
5. Lisinopril (Cardiovascular)
6. Atorvastatin (Cardiovascular)
7. Omeprazole (Gastrointestinal)
8. Sertraline (Mental Health)
9. Montelukast (Respiratory)
10. Levothyroxine (Endocrine)

## Notes

- All timestamps are automatically set when adding medicines
- The system checks for existing data before initialization
- CORS is properly configured for frontend integration
- All endpoints support the new comprehensive medicine data structure
