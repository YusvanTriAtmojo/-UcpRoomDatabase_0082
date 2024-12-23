package com.example.ucp2.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Card(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .height(450.dp)
                    .width(500.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF01A58B)),
            )
            {
                Text(
                    modifier = Modifier.padding(start = 120.dp, top = 20.dp),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp,
                    color = Color.White,
                    text = "Menu Utama"
                )
            }
        }
    }
}
