package com.example.weatherapp.Presentation.Screens

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weatherapp.HomeScreen
import com.example.weatherapp.R

@Composable
fun SplashScreen(navController: NavHostController) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(145, 114, 216))
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(235.dp),
                painter = painterResource(id = R.drawable.splashicon),

                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(100.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp), strokeWidth = 5.dp, color = Color(223, 202, 241)
            )

        }

        Handler(Looper.getMainLooper()).postDelayed(Runnable{
            navController.navigate(HomeScreen)
        },3500)
    }


}