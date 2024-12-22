package com.example.ucp2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.data.entity.Suplier
import com.example.ucp2.repository.RepositorySpr
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class ListSprViewModel(
    private val repositorySpr: RepositorySpr
) : ViewModel() {
    val listSprUiState: StateFlow<ListSprUiState> = repositorySpr.getAllSpr()
        .filterNotNull()
        .map {
            ListSprUiState(
                listSpr = it.toList(),
                isLoading = false,
            )
        }
        .onStart {
            emit(ListSprUiState(isLoading = true))
            delay(900)
        }
        .catch {
            emit(
                ListSprUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ListSprUiState(
                isLoading = true,
            )
        )
}


data class ListSprUiState(
    val listSpr: List<Suplier> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)