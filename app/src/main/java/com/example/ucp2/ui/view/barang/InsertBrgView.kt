package com.example.ucp2.ui.view.barang

import DynamicSelectedTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ucp2.data.NamaSuplier
import com.example.ucp2.data.entity.Suplier
import com.example.ucp2.ui.viewmodel.BarangEvent
import com.example.ucp2.ui.viewmodel.FormErrorStatebrg

@Preview(showBackground = true)
@Composable
fun FormBarang(
    barangEvent: BarangEvent = BarangEvent(),
    onValueChange: (BarangEvent) -> Unit = {},
    suplierList: List<Suplier> = listOf(),
    errorState: FormErrorStatebrg = FormErrorStatebrg(),
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = barangEvent.id,
            onValueChange = {
                onValueChange(barangEvent.copy(id = it))
            },

            label = { Text("ID") },
            isError = errorState.id != null,
            placeholder = { Text("Masukkan id") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            shape = RoundedCornerShape(50.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = ""
                )
            }
        )
        Text(
            text = errorState.id ?: "",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = barangEvent.nama,
            onValueChange = {
                onValueChange(barangEvent.copy(nama = it))
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
                    contentDescription = ""
                )
            }
        )
        Text(
            text = errorState.nama ?: "",
            color = Color.Red
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = barangEvent.deskripsi,
            onValueChange = {
                onValueChange(barangEvent.copy(deskripsi = it))
            },
            label = { Text("Deskripsi") },
            isError = errorState.deskripsi != null,
            placeholder = { Text("Masukkan Deskripsi") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            shape = RoundedCornerShape(50.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = ""
                )
            }
        )
        Text(
            text = errorState.deskripsi ?: "",
            color = Color.Red
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = barangEvent.harga.toString(),
            onValueChange = {
                onValueChange(barangEvent.copy(harga = it.toDoubleOrNull() ?: 0.00))
            },
            label = { Text("Harga") },
            isError = errorState.harga != null,
            placeholder = { Text("Masukkan Harga") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            shape = RoundedCornerShape(50.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = ""
                )
            }
        )
        Text(
            text = errorState.harga ?: "",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = barangEvent.stok.toString(),
            onValueChange = {
                onValueChange(barangEvent.copy(stok = it.toIntOrNull() ?: 0))
            },
            label = { Text("Stok") },
            isError = errorState.stok != null,
            placeholder = { Text("Masukkan Stok") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            shape = RoundedCornerShape(50.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = ""
                )
            }
        )
        Text(
            text = errorState.stok ?: "",
            color = Color.Red
        )

        DynamicSelectedTextField(
            selectedValue = barangEvent.namaSuplier,
            label = "Pilih Supplier",
            onValueChangedEvent = { pilihanSuplier ->
                onValueChange(barangEvent.copy(namaSuplier = pilihanSuplier))
            },
            pilihan = NamaSuplier.ListNamaSuplier()
        )
        Text(
            text = errorState.namaSuplier ?: "",
            color = Color.Red
        )
    }
}

