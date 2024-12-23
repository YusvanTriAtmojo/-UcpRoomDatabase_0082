package com.example.ucp2.ui.view.barang

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp2.data.entity.Barang

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