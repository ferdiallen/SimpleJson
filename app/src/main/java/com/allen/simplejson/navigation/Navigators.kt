package com.allen.simplejson.navigation

sealed class Navigators(val route:String){
    object Main:Navigators(route = "main_display")
    object Login:Navigators(route = "login")
}
