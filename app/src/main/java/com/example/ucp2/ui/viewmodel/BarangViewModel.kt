package com.example.ucp2.ui.viewmodel


data class BarangEvent(
    val id: String = "",
    val nama: String = "",
    val deskripsi: String = "",
    val harga: Double = 0.00,
    val stok: Int = 0,
    val namaSuplier: String = ""
)