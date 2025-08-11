package com.dailypluse

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dailypluse.articles.presentation.ArticleState
import com.dailypluse.articles.presentation.ArticlesViewModel
import com.dailypluse.screens.AboutScreen
import com.dailypluse.screens.ArticlesScreen
import com.dailypluse.screens.Screens

@Composable
fun AppScaffold(){
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}


@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier= Modifier
){
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.rout,
        modifier = modifier,
    ){
        composable(Screens.ARTICLES.rout) {
            ArticlesScreen(
                onAboutClick = {
                    navController.navigate(Screens.ABOUT_DEVICE.rout)
                }
            )
        }

        composable(Screens.ABOUT_DEVICE.rout) {
            AboutScreen(
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
