import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:flutter_animate/flutter_animate.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

import 'providers/medicine_provider.dart';
import 'models/medicine.dart';
import 'screens/dashboard_screen.dart';
import 'screens/medicine_detail_screen.dart';
import 'screens/premium_medicine_detail_screen.dart';
import 'screens/add_medicine_screen.dart';
import 'screens/advanced_search_screen.dart';
import 'screens/search_screen.dart';
import 'theme/app_theme.dart';

void main() {
  runApp(const HealixApp());
}

class HealixApp extends StatelessWidget {
  const HealixApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => MedicineProvider()),
      ],
      child: MaterialApp(
        title: 'Healix - Medical Visual Aid',
        debugShowCheckedModeBanner: false,
        theme: AppTheme.lightTheme,
        home: const SplashScreen(),
        routes: {
          '/dashboard': (context) => const DashboardScreen(),
          '/detail': (context) {
            final medicine =
                ModalRoute.of(context)!.settings.arguments as Medicine;
            return MedicineDetailScreen(medicine: medicine);
          },
          '/premium-detail': (context) {
            final medicine =
                ModalRoute.of(context)!.settings.arguments as Medicine;
            return PremiumMedicineDetailScreen(medicine: medicine);
          },
          '/add-medicine': (context) => const AddMedicineScreen(),
          '/advanced-search': (context) => const AdvancedSearchScreen(),
          '/search': (context) => const SearchScreen(),
        },
      ),
    );
  }
}

class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    _loadDataAndNavigate();
  }

  Future<void> _loadDataAndNavigate() async {
    await Future.delayed(const Duration(seconds: 2));
    if (mounted) {
      Navigator.pushReplacementNamed(context, '/dashboard');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: const BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
            colors: [
              Color(0xFF667eea),
              Color(0xFF764ba2),
            ],
          ),
        ),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              // Icon with quick scale + rotation + fade
              Container(
                width: 120,
                height: 120,
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(30),
                  boxShadow: [
                    BoxShadow(
                      color: Colors.black.withOpacity(0.2),
                      blurRadius: 20,
                      offset: const Offset(0, 10),
                    ),
                  ],
                ),
                child: const Icon(
                  FontAwesomeIcons.stethoscope,
                  size: 60,
                  color: Color(0xFF667eea),
                ),
              )
                  .animate() // flutter_animate
                  .scale(
                    duration: 500.ms,
                    curve: Curves.easeInOut,
                  )
                  .shake(duration: 500.ms, hz: 4) // quick shake
                  .fadeIn(duration: 400.ms),

              const SizedBox(height: 30),

              // Title: fast slide + fade + scale
              Text(
                'HEALIX',
                style: GoogleFonts.poppins(
                  fontSize: 36,
                  fontWeight: FontWeight.bold,
                  color: Colors.white,
                  letterSpacing: 2,
                ),
              ).animate()
                  .fadeIn(duration: 400.ms)
                  .slide(
                    begin: const Offset(0, 1),
                    end: Offset.zero,
                    curve: Curves.easeOut,
                    duration: 400.ms,
                  )
                  .scale(duration: 400.ms, curve: Curves.easeOutBack),

              const SizedBox(height: 10),

              // Subtitle: quick fade + slide
              Text(
                'Medical Visual Aid',
                style: GoogleFonts.poppins(
                  fontSize: 16,
                  color: Colors.white70,
                  letterSpacing: 1,
                ),
              ).animate()
                  .fadeIn(duration: 400.ms, delay: 200.ms)
                  .slide(
                    begin: const Offset(0, 0.5),
                    end: Offset.zero,
                    duration: 400.ms,
                    delay: 200.ms,
                    curve: Curves.easeOut,
                  ),

              const SizedBox(height: 50),

              // Loader: fast bounce + fade
              const CircularProgressIndicator(
                valueColor: AlwaysStoppedAnimation<Color>(Colors.white),
              ).animate()
                  .fadeIn(duration: 300.ms, delay: 400.ms)
                  .scale(
                    duration: 500.ms,
                    delay: 400.ms,
                    curve: Curves.easeInOutBack,
                  )
                  .then(delay: 200.ms)
                  .shake(duration: 500.ms, hz: 4),
            ],
          ),
        ),
      ),
    );
  }
}
