package com.example.conectividad5g

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ConnectivityScreen() {
    val context = LocalContext.current
    val connectivityViewModel: ConnectivityViewModel = viewModel()

    val is5GConnected by remember {
        mutableStateOf(connectivityViewModel.is5GConnected(context))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (is5GConnected) "Conectado a 5G" else "No conectado a 5G",
            color = if (is5GConnected) Color.Green else Color.Red,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

