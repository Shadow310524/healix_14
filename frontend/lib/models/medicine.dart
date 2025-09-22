class Medicine {
  final String id;
  final String name;
  final String description;
  final String category;
  final String dosage;
  final List<String> imageUrls;
  final String? pdfUrl;
  final String? videoUrl;
  final DateTime createdAt;
  final List<String> indications;
  final List<String> contraindications;
  final List<String> sideEffects;
  final String manufacturer;
  final double price;
  final List<String> ingredients;
  final String storageConditions;
  final String expiryDate;

  Medicine({
    required this.id,
    required this.name,
    required this.description,
    required this.category,
    required this.dosage,
    required this.imageUrls,
    this.pdfUrl,
    this.videoUrl,
    required this.createdAt,
    this.indications = const [],
    this.contraindications = const [],
    this.sideEffects = const [],
    this.manufacturer = '',
    this.price = 0.0,
    this.ingredients = const [],
    this.storageConditions = '',
    this.expiryDate = '',
  });

  factory Medicine.fromJson(Map<String, dynamic> json) {
    return Medicine(
      id: json['id'] ?? '',
      name: json['name'] ?? '',
      description: json['description'] ?? '',
      category: json['category'] ?? '',
      dosage: json['dosage'] ?? '',
      imageUrls: List<String>.from(json['imageUrls'] ?? []),
      pdfUrl: json['pdfUrl'],
      videoUrl: json['videoUrl'],
      createdAt: DateTime.parse(json['createdAt'] ?? DateTime.now().toIso8601String()),
      indications: List<String>.from(json['indications'] ?? []),
      contraindications: List<String>.from(json['contraindications'] ?? []),
      sideEffects: List<String>.from(json['sideEffects'] ?? []),
      manufacturer: json['manufacturer'] ?? '',
      price: (json['price'] ?? 0.0).toDouble(),
      ingredients: List<String>.from(json['ingredients'] ?? []),
      storageConditions: json['storageConditions'] ?? '',
      expiryDate: json['expiryDate'] ?? '',
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'description': description,
      'category': category,
      'dosage': dosage,
      'imageUrls': imageUrls,
      'pdfUrl': pdfUrl,
      'videoUrl': videoUrl,
      'createdAt': createdAt.toIso8601String().substring(0,19),
      'indications': indications,
      'contraindications': contraindications,
      'sideEffects': sideEffects,
      'manufacturer': manufacturer,
      'price': price,
      'ingredients': ingredients,
      'storageConditions': storageConditions,
      'expiryDate': expiryDate,
    };
  }
}
