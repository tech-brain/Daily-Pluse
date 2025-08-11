package com.dailypluse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dailypluse.articles.presentation.ArticlesViewModel
import com.dailypluse.screens.AboutScreen
import com.dailypluse.screens.ArticlesScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            //App()

            //AboutScreen()
            inits()
        }
    }
}

@Composable
fun inits(){

    //ArticlesScreen(articleViewModel)
    AppScaffold()
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}