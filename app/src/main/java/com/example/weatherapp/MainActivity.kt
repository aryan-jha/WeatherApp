package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.Domain.ViewModel.WeatherViewModel
import com.example.weatherapp.Presentation.Screens.SearchScreen
import com.example.weatherapp.ui.theme.WeatherAppTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {

    val viewModel : WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding()
                        .background(brush = gradient)){
                        
                        val navController = rememberNavController()
                        
                        NavHost(navController = navController, startDestination = SplashScreen) {
                            composable<SplashScreen> { 
                                com.example.weatherapp.Presentation.Screens.SplashScreen(navController)
                            }
                            composable<HomeScreen> { 
                                SearchScreen(viewModel = viewModel)
                            }
                        }
                        
                    }
                }
            }
        }
    }
}
val color1 = Color(0xFFD1A0E6) // RGB(209, 160, 230)
val color2 = Color(0xFFB699E3) // RGB(182, 153, 227)
val gradient = Brush.horizontalGradient(

    colors = listOf(color1, color2)
)


@Serializable
object SplashScreen

@Serializable
object HomeScreen
