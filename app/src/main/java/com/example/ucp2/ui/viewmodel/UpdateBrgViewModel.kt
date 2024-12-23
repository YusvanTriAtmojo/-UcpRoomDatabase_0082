package com.example.ucp2.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Barang
import com.example.ucp2.repository.RepositoryBrg
import com.example.ucp2.ui.navigation.DestinasiUpdateBrg
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UpdateBrgViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryBrg: RepositoryBrg
) : ViewModel() {
    var updateUIState by mutableStateOf(BrgUIState())
    private val _id: Int = checkNotNull(savedStateHandle[DestinasiUpdateBrg.ID])

    init {
        viewModelScope.launch {
            updateUIState = repositoryBrg.getBrg(_id)
                .filterNotNull()
                .first()
                .toUIStateBrg()
        }
    }

    fun updateState (barangEvent: BarangEvent) {
        updateUIState = updateUIState.copy(
            barangEvent = barangEvent,
        )
    }

    fun validateFields(): Boolean {
        val event = updateUIState.barangEvent
        val errorState = FormErrorStatebrg(
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            deskripsi = if (event.deskripsi.isNotEmpty()) null else "Jenis kelamin tidak boleh kosong",
            harga = if (event.harga > 0) null else "Harga tidak boleh kosong",
            stok = if (event.stok >= 0) null else "Stok tidak boleh kosong",
            namaSuplier = if (event.namaSuplier.isNotEmpty()) null else "Nama Suplier tidak boleh kosong"
        )

        updateUIState = updateUIState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun updateData() {
        val currentEvent = updateUIState.barangEvent

        if (validateFields()) {
            viewModelScope.launch {
                try{
                    repositoryBrg.updateBrg(currentEvent.toBarangEntity())
                    updateUIState = updateUIState.copy(
                        snackBarMessage = "Data berhasil diupdate",
                        barangEvent = BarangEvent(),
                        isEntryValid = FormErrorStatebrg()
                    )
                    println("snackBarMessage diatur: ${updateUIState.
                    snackBarMessage}")
                } catch (e: Exception) {
                    updateUIState = updateUIState.copy(
                        snackBarMessage = "Data gagal diupdate"
                    )
                }
            }
        } else{
            updateUIState = updateUIState.copy(
                snackBarMessage = "Data gagal diupdate"
            )
        }
    }

    fun resetSnackBarMessage() {
        updateUIState = updateUIState.copy(snackBarMessage = null)
    }
}

fun Barang.toUIStateBrg() : BrgUIState = BrgUIState(
    barangEvent = this.toDetailBrgUiEvent(),
)