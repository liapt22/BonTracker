package com.example.bontracker.pages

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.bontracker.AuthViewModel

// Definim obiectul pentru permisiuni
object CameraXPermissions {
    val CAMERAX_PERMISSIONS = arrayOf(
        Manifest.permission.CAMERA
    )
}

// Funcție care verifică dacă permisiunile sunt acordate
fun hasRequiredPermissions(context: Context): Boolean {
    return CameraXPermissions.CAMERAX_PERMISSIONS.all { permission ->
        ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }
}
@Composable
fun HomePage(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "SALUT")
        Button(onClick = {
            navController.navigate("login")
        }) {
            Text(text="Sign out")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            authViewModel.signout()
            navController.navigate("camera")
        }) {
            Text(text="Camera")
        }
    }
}