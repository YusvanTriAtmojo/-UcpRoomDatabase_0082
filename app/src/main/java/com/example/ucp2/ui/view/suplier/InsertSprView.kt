package com.example.ucp2.ui.view.suplier

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ucp2.ui.viewmodel.FormErrorStatespr
import com.example.ucp2.ui.viewmodel.SprUIState
import com.example.ucp2.ui.viewmodel.SuplierEvent

@Composable
fun InsertBodySpr(
    modifier: Modifier = Modifier,
    onValueChange: (SuplierEvent) -> Unit,
    uiState: SprUIState,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormSuplier(
            suplierEvent = uiState.suplierEvent,
            onValueChange = onValueChange,
            errorState = uiState.isEntryValid,
            modifier = Modifier.fillMaxWidth()
        )
        Button (
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF016D47),
                contentColor = Color.White
            )
        ) {
            Text("Simpan")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormSuplier(
    suplierEvent: SuplierEvent = SuplierEvent(),
    onValueChange: (SuplierEvent) -> Unit = {},
    errorState: FormErrorStatespr = FormErrorStatespr(),
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = suplierEvent.nama,
            onValueChange = {
                onValueChange(suplierEvent.copy(nama = it))
            },
            label = { Text("Nama") },
            isError = errorState.nama != null,
            placeholder = { Text("Masukkan nama") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            shape = RoundedCornerShape(50.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Leading Icon"
                )
            }
        )
        Text(
            text = errorState.nama ?: "",
            color = Color.Red
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = suplierEvent.kontak.toString(),
            onValueChange = {
                onValueChange(suplierEvent.copy(kontak = it.toIntOrNull() ?: 0))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            shape = RoundedCornerShape(50.dp),
            label = { Text("Kontak") },
            isError = errorState.id != null,
            placeholder = { Text("Masukkan Kontak") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Leading Icon"
                )
            }
        )
        Text(
            text = errorState.kontak ?: "",
            color = Color.Red
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = suplierEvent.alamat,
            onValueChange = {
                onValueChange(suplierEvent.copy(alamat = it))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            shape = RoundedCornerShape(50.dp),
            label = { Text("Alamat") },
            isError = errorState.id != null,
            placeholder = { Text("Masukkan Alamat") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Leading Icon"
                )
            }
        )
        Text(
            text = errorState.alamat ?: "",
            color = Color.Red
        )
    }
}