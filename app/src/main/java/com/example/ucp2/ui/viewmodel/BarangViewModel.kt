package com.example.ucp2.ui.viewmodel

import com.example.ucp2.data.entity.Barang


fun BarangEvent.toBarangEntity(): Barang = Barang (
    id = id,
    nama = nama,
    deskripsi = deskripsi,
    harga = harga,
    stok = stok,
    namaSuplier = namaSuplier
)

data class BarangEvent(
    val id: String = "",
    val nama: String = "",
    val deskripsi: String = "",
    val harga: Double = 0.00,
    val stok: Int = 0,
    val namaSuplier: String = ""
)