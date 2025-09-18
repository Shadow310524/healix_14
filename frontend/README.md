# Healix - Medical Visual Aid

A beautiful Flutter application designed for medical representatives to showcase pharmaceutical products to doctors using tablets. This app serves as a digital visual aid, replacing traditional paper brochures with an interactive, modern interface.

## Features

### 🎨 Beautiful UI/UX
- Modern gradient designs with smooth animations
- Tablet-optimized interface for presentations
- Professional medical theme with clean typography
- Responsive grid layouts for easy browsing

### 🔍 Smart Search & Filtering
- Real-time search by medicine name or description
- Category-based filtering
- Instant results with smooth animations

### 📱 Rich Media Support
- High-quality image galleries with full-screen viewing
- Video playback capabilities
- PDF document viewing
- Smooth photo transitions and zoom functionality

### 💊 Comprehensive Medicine Information
- Detailed medicine profiles
- Dosage information
- Category classification
- Creation timestamps
- Rich descriptions

### 🚀 Performance Optimized
- Cached network images for fast loading
- Smooth animations with flutter_animate
- Efficient state management with Provider
- Optimized for tablet presentations

## Technology Stack

- **Frontend**: Flutter 3.0+
- **State Management**: Provider
- **HTTP Client**: Dio
- **Image Caching**: cached_network_image
- **Animations**: flutter_animate
- **Typography**: Google Fonts (Poppins)
- **Icons**: Font Awesome Flutter
- **Media**: photo_view, video_player, flutter_pdfview

## Project Structure

```
frontend/
├── lib/
│   ├── main.dart                 # App entry point with splash screen
│   ├── models/
│   │   └── medicine.dart         # Medicine data model
│   ├── providers/
│   │   └── medicine_provider.dart # State management
│   ├── screens/
│   │   ├── dashboard_screen.dart # Main medicine grid
│   │   ├── medicine_detail_screen.dart # Detailed view
│   │   └── search_screen.dart    # Search functionality
│   ├── services/
│   │   └── api_service.dart      # Backend API integration
│   ├── theme/
│   │   └── app_theme.dart        # App theming
│   └── widgets/
│       ├── medicine_card.dart    # Medicine grid item
│       ├── category_chip.dart    # Category filter chips
│       ├── search_bar.dart       # Custom search input
│       └── media_viewer.dart    # Full-screen image viewer
├── assets/
│   ├── images/                   # App images
│   ├── icons/                    # Custom icons
│   └── fonts/                    # Custom fonts
└── pubspec.yaml                  # Dependencies
```

## Getting Started

### Prerequisites
- Flutter SDK 3.0 or higher
- Dart SDK 3.0 or higher
- Android Studio / VS Code
- Backend API running on localhost:8080

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd healix/frontend
   ```

2. **Install dependencies**
   ```bash
   flutter pub get
   ```

3. **Run the application**
   ```bash
   flutter run
   ```

### Backend Integration

The app connects to a Spring Boot backend with the following endpoints:
- `GET /pharma/get` - Fetch all medicines
- `GET /pharma/get/{id}` - Fetch medicine by ID
- `GET /pharma/get/search/{name}` - Search medicine by name
- `PATCH /pharma/update` - Update medicine
- `DELETE /pharma/delete/{id}` - Delete medicine

## Usage for Medical Representatives

### Dashboard
- Browse medicines in a beautiful grid layout
- Use category filters to narrow down products
- Tap any medicine card to view detailed information

### Search
- Access search from the dashboard
- Type medicine names or descriptions
- Get instant results with smooth animations

### Medicine Details
- View comprehensive medicine information
- Browse image galleries with full-screen viewing
- Watch product videos
- Read PDF documents
- Share information with doctors

### Presentation Mode
- Optimized for tablet viewing
- Full-screen media viewing
- Professional animations and transitions
- Easy navigation for presentations

## Customization

### Themes
Modify `lib/theme/app_theme.dart` to customize:
- Color schemes
- Typography
- Card styles
- Button designs

### API Configuration
Update `lib/services/api_service.dart` to change:
- Base URL
- Request timeouts
- Error handling

### UI Components
Customize widgets in `lib/widgets/` for:
- Card designs
- Search functionality
- Media viewers
- Category filters

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support and questions, please contact the development team or create an issue in the repository.
