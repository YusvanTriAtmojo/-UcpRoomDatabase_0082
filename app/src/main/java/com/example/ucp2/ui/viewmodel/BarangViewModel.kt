package com.example.ucp2.ui.viewmodel

import com.example.ucp2.data.entity.Barang

data class BrgUIState(
    val barangEvent: BarangEvent = BarangEvent(),
    var isEntryValid: FormErrorStatebrg = FormErrorStatebrg(),
    val snackBarMessage: String? = null,
)

data class FormErrorStatebrg(
    val id: String? = null,
    val nama: String? = null,
    val deskripsi: String? = null,
    val harga: String? = null,
    val stok: String? = null,
    val namaSuplier: String? = null,
) {
    fun isValid(): Boolean {
        return id == null && nama == null && deskripsi == null &&
                harga  == null && stok == null && namaSuplier == null
    }
}

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