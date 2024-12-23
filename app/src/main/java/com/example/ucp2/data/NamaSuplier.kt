package com.example.ucp2.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2.ui.viewmodel.ListSprViewModel
import com.example.ucp2.ui.viewmodel.PenyediaViewModel

object NamaSuplier {
    @Composable
    fun ListNamaSuplier(
        listSpr: ListSprViewModel = viewModel(factory = PenyediaViewModel.Factory1)
    ) : List<String> {
        val listNamaSpr by listSpr.listSprUiState.collectAsState()
        val NamaSpr = listNamaSpr.listSpr.map { it.nama }
        return NamaSpr
    }
}