package com.example.ucp2.ui.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ucp2.ui.customwidget.TopAppBar


@Composable
fun HomeView(
    keListBarang: () -> Unit,
    keListSuplier: () -> Unit,
    keAddBarang: () -> Unit,
    keAddSuplier: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier.padding(top = 25.dp),
        topBar = {
            TopAppBar(
                onBack = {},
                showBackButton = false,
                judul = "Inventaris",
                subjudul =  "Toko Alat Tulis ATK",
                modifier = Modifier
            )
        }
    ) {

    }
}
