package com.example.jetpackcomposemovieapp.navigations

enum class MovieScreens {
    HomeScreen,
    DetailScreen;
    companion object {
        fun fromRoute(route: String?): MovieScreens=
            when(route?.substringBefore("/")){
                HomeScreen.name-> HomeScreen
                DetailScreen.name->DetailScreen
                null->HomeScreen
                else-> throw IllegalArgumentException("route $route is not recognized")
            }
    }
}