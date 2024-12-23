package com.example.ucp2.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
                Row {
                    Card(
                        onClick = keListBarang,
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF016D47)),
                        modifier = Modifier
                            .padding(start = 45.dp, 20.dp)
                            .height(150.dp)
                            .width(150.dp)
                    ) {
                        Column(
                            modifier = modifier
                                .padding(30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.List,
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier.padding(start = 30.dp, top = 20.dp),
                            )
                            Text(
                                color = Color.White,
                                text = "List Barang"
                            )
                        }
                    }

                    Card(
                        onClick = keAddBarang,
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF016D47)),
                        modifier = Modifier
                            .padding(20.dp)
                            .height(150.dp)
                            .width(150.dp)
                    ) {
                        Column(
                            modifier = modifier
                                .padding(30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier.padding(start = 30.dp, top = 20.dp)
                            )
                            Text(
                                color = Color.White,
                                text = "Add Barang"
                            )
                        }
                    }
                }
                Row {
                    Card(
                        onClick = keListSuplier,
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF016D47)),
                        modifier = Modifier
                            .padding(start = 45.dp, 20.dp)
                            .height(150.dp)
                            .width(150.dp)
                    ) {
                        Column(
                            modifier = modifier
                                .padding(30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier.padding(start = 30.dp, top = 20.dp)
                            )
                            Text(
                                color = Color.White,
                                text = "List Suplier"
                            )
                        }
                    }

                    Card(
                        onClick = keAddSuplier,
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF016D47)),
                        modifier = Modifier
                            .padding(20.dp)
                            .height(150.dp)
                            .width(150.dp)
                    ) {
                        Column(
                            modifier = modifier
                                .padding(30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "",
                                tint = Color.White,
                                modifier = Modifier.padding(start = 30.dp, top = 20.dp)
                            )
                            Text(
                                color = Color.White,
                                text = "Add Suplier"
                            )
                        }
                    }
                }
            }
        }
    }
}
