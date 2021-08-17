package com.steve.bottomnavigationcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun Search(navController: NavHostController) {

    Column (modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center){
        Text(text = "Search")
    }

}