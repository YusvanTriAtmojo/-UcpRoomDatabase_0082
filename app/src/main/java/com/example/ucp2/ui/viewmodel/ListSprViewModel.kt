package com.example.ucp2.ui.viewmodel

import com.example.ucp2.data.entity.Suplier

data class ListSprUiState(
    val listSpr: List<Suplier> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)