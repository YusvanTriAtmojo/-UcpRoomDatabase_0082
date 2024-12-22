package com.example.ucp2.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Suplier
import com.example.ucp2.repository.RepositorySpr
import kotlinx.coroutines.launch

class SuplierViewModel(
    private val repositorySpr: RepositorySpr
) : ViewModel() {
    var uiState by mutableStateOf(SprUIState())


    fun updateState(suplierEvent: SuplierEvent) {
        uiState = uiState.copy(
            suplierEvent = suplierEvent,

            )
    }


    private fun validateFields(): Boolean {
        val event = uiState.suplierEvent
        val errorState = FormErrorStatespr(
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            kontak = if (event.kontak > 0) null else "Kontak tidak boleh kosong",
            alamat = if (event.alamat.isNotEmpty()) null else "Alamat tidak boleh kosong",
        )

        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun saveData(){
        val currentEvent = uiState.suplierEvent

        if(validateFields()) {
            viewModelScope.launch {
                try {
                    repositorySpr.insertSpr(currentEvent.toSuplierEntity())
                    uiState = uiState.copy(
                        snackBarMessage = "Data berhasil disimpan",
                        suplierEvent = SuplierEvent(), //Reset input form
                        isEntryValid = FormErrorStatespr() //Reset error state
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


data class SprUIState(
    val suplierEvent: SuplierEvent = SuplierEvent(),
    var isEntryValid: FormErrorStatespr = FormErrorStatespr(),
    val snackBarMessage: String? = null,
)


data class FormErrorStatespr(
    val id: String? = null,
    val nama: String? = null,
    val kontak: String? = null,
    val alamat: String? = null,
) {
    fun isValid(): Boolean {
        return id == null && nama == null && kontak == null &&
                alamat  == null
    }
}

fun SuplierEvent.toSuplierEntity(): Suplier = Suplier (
    id = id,
    nama = nama,
    kontak = kontak,
    alamat = alamat,
)

data class SuplierEvent(
    val id: Int = 0,
    val nama: String = "",
    val kontak: Int = 0,
    val alamat: String = "",
)