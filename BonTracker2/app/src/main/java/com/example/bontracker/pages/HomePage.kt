package com.example.bontracker.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.bontracker.AuthViewModel

@Composable
fun HomePage(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "SALUT")
        Button(onClick = {
            authViewModel.signout()
            navController.navigate("login")
        }) {
            Text(text="Sign out")
        }
    }
}