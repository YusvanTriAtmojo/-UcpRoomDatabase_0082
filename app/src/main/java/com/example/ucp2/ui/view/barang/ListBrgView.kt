package com.example.ucp2.ui.view.barang

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.data.entity.Barang
import com.example.ucp2.ui.customwidget.TopAppBar
import com.example.ucp2.ui.viewmodel.ListBrgUiState
import com.example.ucp2.ui.viewmodel.ListBrgViewModel
import com.example.ucp2.ui.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

@Composable
fun ListBrgView(
    viewModel: ListBrgViewModel = viewModel(factory = PenyediaViewModel.Factory),
    onBack: () -> Unit = { },
    onDetailClick: (Int) -> Unit = { },
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = Modifier.padding(top = 25.dp),
        topBar = {
            TopAppBar(
                judul = "Daftar Barang",
                subjudul = "",
                showBackButton = true,
                showIcon = false,
                showImage = false,
                onBack = onBack,
                modifier = modifier
            )
        },
    ) { innerPadding ->
        val listUiState by viewModel.listBrgUiState.collectAsState()

        Card ( modifier = modifier.height(1000.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)) {
            BodyHomeBrgView(
                listUiState = listUiState,
                onClick = {
                    onDetailClick(it)
                },
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun BodyHomeBrgView(
    listUiState: ListBrgUiState,
    onClick: (Int) -> Unit = { },
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    when {
        listUiState.isLoading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        listUiState.isError -> {
            LaunchedEffect(listUiState.errorMessage) {
                listUiState.errorMessage?.let { message ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(message) //tampilkan Snackbar
                    }
                }
            }
        }
        listUiState.listBrg.isEmpty() -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Tidak ada data Barang.",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        else -> {
            ListBarang(
                listBrg = listUiState.listBrg,
                onClick = {
                    onClick(it)
                    println(
                        it
                    )
                },
                modifier = modifier
            )
        }
    }
}

@Composable
fun ListBarang(
    listBrg: List<Barang>,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = { }
) {
    LazyColumn (
        modifier = modifier
    ) {
        items(
            items = listBrg,
            itemContent = { brg ->
                CardBrg(
                    brg = brg,
                    onClick = { onClick(brg.id) }
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardBrg (
    brg: Barang,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
    backgroundColor: Color? = null
) {
    Card (modifier = modifier.padding(top = 10.dp),colors = CardDefaults.cardColors(containerColor = Color.White)){
        Card(
            onClick = onClick,
            modifier = modifier.padding(top = 2.dp)
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = backgroundColor ?: if (brg.stok == 0) {
                    Color.Gray
                } else if (brg.stok in 1..10) {
                    Color.Red
                } else {
                    Color(0xFF228B22)
                }
            )
        ) {
            Row {
                Icon(modifier = Modifier.padding(30.dp).size(80.dp),
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "",
                    tint = Color.White
                )
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            text = brg.nama,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            text = brg.stok.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            text = brg.namaSuplier,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
        Row {
            Text(
                modifier = modifier.padding(start = 150.dp, bottom = 10.dp),
                text = "Harga Rp. ",
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = brg.harga.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}