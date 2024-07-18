package com.example.weatherapp.Presentation.Screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.example.weatherapp.Domain.API.NetworkResponse
import com.example.weatherapp.Domain.ViewModel.WeatherViewModel

@Composable
fun SearchScreen(viewModel: WeatherViewModel) {

    var place by remember { mutableStateOf("") }
    var keyboardController = LocalSoftwareKeyboardController.current

    val weatherResult = viewModel.weatherResult.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 75.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row() {
            OutlinedTextField(
                shape = RoundedCornerShape(15.dp),
                label = { Text(text = "Search") },
                value = place,
                onValueChange = { place = it }
            )

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(onClick = {
                viewModel.getPlace(place)
                keyboardController?.hide()
                                 },
                modifier = Modifier.padding(top = 12.dp)) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color(90, 83, 98)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (val result = weatherResult.value) {
            is NetworkResponse.Success -> {
                InfoScreen(result.data)
            }

            is NetworkResponse.Error -> {
                Text(text = result.message)
            }

            is NetworkResponse.Loading -> {
                Log.d("loading", "yes")
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp), strokeWidth = 5.dp, color = Color(223, 202, 241)
                )
            }
            null -> {}
        }
    }
}