package com.example.ucp2.ui.viewmodel

import com.example.ucp2.data.entity.Barang

data class ListBrgUiState(
    val listBrg: List<Barang> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)