package com.example.weatherapp.Presentation.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.Domain.API.NetworkResponse
import com.example.weatherapp.Domain.ViewModel.WeatherViewModel


@Composable
fun SearchScreen(viewModel: WeatherViewModel) {

    var place by remember { mutableStateOf("") }

    val weatherResult = viewModel.weatherResult.observeAsState()

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Row {
            OutlinedTextField(value = place, onValueChange = { place = it })

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        viewModel.getPlace(place)
                    }
            ) {

                    Icon(
                        modifier = Modifier.size(45.dp),
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )

            }




        }
        when(val result = weatherResult.value){
            is NetworkResponse.Success -> {
                Text(text = result.data.toString())
            }

            is NetworkResponse.Error -> {
                Text(text = result.message)
            }

            is NetworkResponse.Loading -> {
                CircularProgressIndicator()
            }
            null -> {}
        }

    }



}