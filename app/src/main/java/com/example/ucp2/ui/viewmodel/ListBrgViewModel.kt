package com.example.ucp2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Barang
import com.example.ucp2.repository.RepositoryBrg
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class ListBrgViewModel (
    private val repositoryBrg: RepositoryBrg
) : ViewModel() {
    val listBrgUiState: StateFlow<ListBrgUiState> = repositoryBrg.getAllBrg()
        .filterNotNull()
        .map {
            ListBrgUiState(
                listBrg = it.toList(),
                isLoading = false,
            )
        }
        .onStart {
            emit(ListBrgUiState(isLoading = true))
            delay(900)
        }
        .catch {
            emit(
                ListBrgUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ListBrgUiState(
                isLoading = true,
            )
        )
}


data class ListBrgUiState(
    val listBrg: List<Barang> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)