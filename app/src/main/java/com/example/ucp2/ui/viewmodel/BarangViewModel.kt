package com.example.ucp2.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Barang
import com.example.ucp2.repository.RepositoryBrg
import kotlinx.coroutines.launch

class BarangViewModel(
    private val repositoryBrg: RepositoryBrg
) : ViewModel() {
    var uiState by mutableStateOf(BrgUIState())

    fun updateBrgState(barangEvent: BarangEvent) {
        uiState = uiState.copy(
            barangEvent = barangEvent,

            )
    }

    private fun validateFields(): Boolean {
        val event = uiState.barangEvent
        val errorState = FormErrorStatebrg(
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            deskripsi = if (event.deskripsi.isNotEmpty()) null else "Deskripsi tidak boleh kosong",
            harga = if (event.harga > 0) null else "Harga tidak boleh kosong",
            stok = if (event.stok >= 0) null else "Stok tidak boleh kosong",
            namaSuplier = if (event.namaSuplier.isNotEmpty()) null else "Nama Suplier tidak boleh kosong"
        )

        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }
    fun saveData(){
        val currentEvent = uiState.barangEvent

        if(validateFields()) {
            viewModelScope.launch {
                try {
                    repositoryBrg.insertBrg(currentEvent.toBarangEntity())
                    uiState = uiState.copy(
                        snackBarMessage = "Data berhasil disimpan",
                        barangEvent = BarangEvent(), //Reset input form
                        isEntryValid = FormErrorStatebrg() //Reset error state
                    )
                } catch (e: Exception) {
                    uiState = uiState.copy(
                        snackBarMessage = "Data gagal disimpan"
                    )
                }
            }
        } else {
            uiState = uiState.copy(
                snackBarMessage = "Input tidak valid. Periksa kembali data Anda."
            )
        }
    }

    fun resetSnackBarMessage(){
        uiState = uiState.copy(snackBarMessage = null)
    }
}

data class BrgUIState(
    val barangEvent: BarangEvent = BarangEvent(),
    var isEntryValid: FormErrorStatebrg = FormErrorStatebrg(),
    val snackBarMessage: String? = null,
)

data class FormErrorStatebrg(
    val id: String? = null,
    val nama: String? = null,
    val deskripsi: String? = null,
    val harga: String? = null,
    val stok: String? = null,
    val namaSuplier: String? = null,
) {
    fun isValid(): Boolean {
        return id == null && nama == null && deskripsi == null &&
                harga  == null && stok == null && namaSuplier == null
    }
}

fun BarangEvent.toBarangEntity(): Barang = Barang (
    id = id,
    nama = nama,
    deskripsi = deskripsi,
    harga = harga,
    stok = stok,
    namaSuplier = namaSuplier
)

data class BarangEvent(
    val id: Int = 0,
    val nama: String = "",
    val deskripsi: String = "",
    val harga: Double = 0.00,
    val stok: Int = 0,
    val namaSuplier: String = ""
)