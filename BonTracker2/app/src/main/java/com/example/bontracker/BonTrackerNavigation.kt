package com.example.bontracker


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bontracker.pages.HomePage
import com.example.bontracker.pages.LoginPage
import com.example.bontracker.pages.SignUpPage


@Composable
fun BonTrackerNavigation(modifier: Modifier,authViewModel: AuthViewModel){
    val navController = rememberNavController()
   NavHost(navController=navController, startDestination = "login"){
       composable("login"){
           LoginPage(modifier, navController,authViewModel)
       }
       composable("signup"){
           SignUpPage(modifier, navController,authViewModel)
       }
       composable("home"){
           HomePage(modifier, navController,authViewModel)
       }
        }

}