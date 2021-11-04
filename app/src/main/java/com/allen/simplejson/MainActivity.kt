package com.allen.simplejson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.allen.simplejson.navigation.LoginDisplay
import com.allen.simplejson.navigation.MainDisplay
import com.allen.simplejson.navigation.Navigators
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    lateinit var navHost: NavHostController

    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navHost = rememberNavController()
            SetNavigator(navHost)
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun SetNavigator(navcon: NavHostController) {
    val sysui = rememberSystemUiController()
    val currentEntry by navcon.currentBackStackEntryAsState()
    NavHost(navController = navcon, startDestination = Navigators.Login.route) {
        composable(route = Navigators.Main.route) {
            MainDisplay(navcon, viewModel())
        }
        composable(route = Navigators.Login.route) {
            LoginDisplay(navcon)
        }
    }
    when (currentEntry?.destination?.route) {
        Navigators.Main.route -> {
            sysui.setStatusBarColor(color = Color.LightGray)
        }
    }
}

