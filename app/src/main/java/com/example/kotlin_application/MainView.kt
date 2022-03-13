package com.example.kotlin_application

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier

@Composable
fun CityView() {

    val vm = viewModel<AddressDataViewModel>()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement= Arrangement.Center,

    ) {

        Button(onClick = {vm.getRandomCityData()}) {
            Text(text = "Where to travel next?")
        }

        Text(text = vm.country.value)
    }


}

