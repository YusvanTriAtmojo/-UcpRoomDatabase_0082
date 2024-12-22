package com.example.ucp2.ui.viewmodel

import com.example.ucp2.data.entity.Barang

fun Barang.toUIStateBrg() : BrgUIState = BrgUIState(
    barangEvent = this.toDetailBrgUiEvent(),
)