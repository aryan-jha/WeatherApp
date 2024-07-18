package com.example.weatherapp.Presentation.Screens

import android.provider.CalendarContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.Data.WeatherResponseModel
import com.example.weatherapp.R

@Composable
fun InfoScreen(value: WeatherResponseModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 21.dp)
        ) {
            Text(
                text = value.location.name,
                fontSize = 50.sp,

                color = Color(90, 83, 98),
//                modifier = Modifier.align(Alignment.CenterHorizontally)

            )
        }
        Spacer(modifier = Modifier.height(9.dp))

        Row {
            AsyncImage(
                modifier = Modifier.size(200.dp),
                model = "https:${value.current.condition.icon}".replace("64x64", "128x128"),
                contentDescription = "Image"
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Text(
                        text = value.current.temp_c,
                        fontSize = 60.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 40.dp)
                    )
                    Text(text = "°c", fontSize = 30.sp, modifier = Modifier.padding(top = 40.dp))
                }
                Text(text = value.current.condition.text, fontSize = 27.sp)
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(223, 202, 241).copy(0.85f)),

                ) {
                Row(
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color.White)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.heatindex),
                            contentDescription = null
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(text = "HeatIndex", fontSize = 21.sp,fontFamily = FontFamily.SansSerif)

                    Spacer(modifier = Modifier.width(84.dp))

                    Text(text = value.current.heatindex_c, fontSize = 21.sp, fontFamily = FontFamily.Serif)

                }

            }
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(223, 202, 241).copy(0.85f)),

                ) {
                Row(
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color.White)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.humidity),
                            contentDescription = null
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(text = "Humidity", fontSize = 21.sp,fontFamily = FontFamily.SansSerif)

                    Spacer(modifier = Modifier.width(95.dp))

                    Text(text = value.current.humidity, fontSize = 21.sp, fontFamily = FontFamily.Serif)
                    Text(text = "%", fontSize = 21.sp, fontFamily = FontFamily.Serif)

                }

            }
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(223, 202, 241).copy(0.85f)),

                ) {
                Row(
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(Color.White)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.wind),
                            contentDescription = null
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(text = "Wind", fontSize = 21.sp,fontFamily = FontFamily.SansSerif)

                    Spacer(modifier = Modifier.width(120.dp))

                    Text(text = value.current.wind_kph, fontSize = 21.sp, fontFamily = FontFamily.Serif)
                    Text(text = "Km/h", fontSize = 12.sp, fontFamily = FontFamily.Serif)

                }

            }
        }


    }


}

