import 'package:flutter/material.dart';
import '../models/medicine.dart';
import '../services/api_service.dart';

class MedicineProvider extends ChangeNotifier {
  final ApiService _apiService = ApiService();
  
  List<Medicine> _medicines = [];
  List<Medicine> _filteredMedicines = [];
  bool _isLoading = false;
  String _error = '';
  String _searchQuery = '';
  String _selectedCategory = 'All';

  List<Medicine> get medicines => _filteredMedicines;
  bool get isLoading => _isLoading;
  String get error => _error;
  String get searchQuery => _searchQuery;
  String get selectedCategory => _selectedCategory;

  List<String> get categories {
    Set<String> categorySet = {'All'};
    for (var medicine in _medicines) {
      categorySet.add(medicine.category);
    }
    return categorySet.toList();
  }

  Future<void> loadMedicines() async {
    _isLoading = true;
    _error = '';
    notifyListeners();

    try {
      _medicines = await _apiService.getAllMedicines();
      _filteredMedicines = _medicines;
      _applyFilters();
    } catch (e) {
      _error = e.toString();
    } finally {
      _isLoading = false;
      notifyListeners();
    }
  }

  void searchMedicines(String query) {
    _searchQuery = query;
    _applyFilters();
  }

  void filterByCategory(String category) {
    _selectedCategory = category;
    _applyFilters();
  }

  void _applyFilters() {
    _filteredMedicines = _medicines.where((medicine) {
      bool matchesSearch = _searchQuery.isEmpty ||
          medicine.name.toLowerCase().contains(_searchQuery.toLowerCase()) ||
          medicine.description.toLowerCase().contains(_searchQuery.toLowerCase());
      
      bool matchesCategory = _selectedCategory == 'All' ||
          medicine.category == _selectedCategory;
      
      return matchesSearch && matchesCategory;
    }).toList();
    
    notifyListeners();
  }

  Future<Medicine?> getMedicineById(String id) async {
    try {
      return await _apiService.getMedicineById(id);
    } catch (e) {
      _error = e.toString();
      notifyListeners();
      return null;
    }
  }

  Future<bool> updateMedicine(Medicine medicine) async {
    try {
      await _apiService.updateMedicine(medicine);
      await loadMedicines(); // Refresh the list
      return true;
    } catch (e) {
      _error = e.toString();
      notifyListeners();
      return false;
    }
  }

  Future<bool> deleteMedicine(String id) async {
    try {
      await _apiService.deleteMedicine(id);
      await loadMedicines(); // Refresh the list
      return true;
    } catch (e) {
      _error = e.toString();
      notifyListeners();
      return false;
    }
  }

  void clearError() {
    _error = '';
    notifyListeners();
  }
}
