package com.example.ucp2.ui.viewmodel

import com.example.ucp2.data.entity.Barang

fun Barang.toDetailBrgUiEvent(): BarangEvent {
    return BarangEvent(
        id = id,
        nama = nama,
        deskripsi = deskripsi,
        harga = harga,
        stok = stok,
        namaSuplier = namaSuplier
    )
}