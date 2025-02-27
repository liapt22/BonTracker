package com.example.bontracker


import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bontracker.pages.HomePage
import com.example.bontracker.pages.LoginPage
import com.example.bontracker.pages.SignUpPage
import androidx.compose.ui.platform.LocalContext


@Composable
fun BonTrackerNavigation(modifier: Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    // Folosește LocalContext.current pentru a obține contextul
    val context = LocalContext.current
    val controller = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(
                CameraController.IMAGE_CAPTURE or CameraController.IMAGE_ANALYSIS
            )
        }
    }

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginPage(modifier, navController, authViewModel)
        }
        composable("signup") {
            SignUpPage(modifier, navController, authViewModel)
        }
        composable("home") {
            HomePage(modifier, navController, authViewModel)
        }
        composable("camera") {
            CameraPreview(controller = controller, modifier = modifier)
        }
    }
}


