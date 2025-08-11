package com.dailypluse.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dailypluse.Platform

@Composable
fun AboutScreen(
    onClick : () -> Unit
){
    Column() {
        Toolbar(onClick ={
            onClick()
        })
        ContentView()
    }
}

@Composable
fun ContentView() {
    val list = contentItems()
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(list) { item ->
            RowView(title = item.first,  subTitle = item.second)
        }
    }
}


fun contentItems() : List<Pair<String, String>>{
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("Density", platform.density.toString())
    )
}

@Composable
fun RowView(
    title: String,
    subTitle : String
){
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        Text(
            text = subTitle,
            style = MaterialTheme.typography.bodyLarge
        )
    }
    HorizontalDivider()

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun  Toolbar(onClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "About Device") },
        navigationIcon = {
            IconButton(onClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        }
    )

}