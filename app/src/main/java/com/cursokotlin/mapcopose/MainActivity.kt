package com.cursokotlin.mapcopose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.cursokotlin.mapcopose.ui.theme.MapCoposeTheme

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MapCoposeTheme {
                MyGoogleMaps()
            }
        }
    }
}

@Composable
fun MyGoogleMaps() {
    val bernabeu = LatLng(40.4530541, -3.6883445)
    val properties by remember { mutableStateOf(MapProperties(mapType = MapType.HYBRID)) }
    val uiSettings by remember { mutableStateOf(MapUiSettings(zoomControlsEnabled = false)) }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = properties,
        uiSettings = uiSettings
    ) {
        Marker(
            position = bernabeu,
            title = "Real Madrid",
            snippet = "Estadio Santiago Bernabéu"
        )
    }
}