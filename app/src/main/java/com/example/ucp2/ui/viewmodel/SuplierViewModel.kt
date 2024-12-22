package com.example.ucp2.ui.viewmodel

import com.example.ucp2.data.entity.Suplier

data class FormErrorStatespr(
    val id: String? = null,
    val nama: String? = null,
    val kontak: String? = null,
    val alamat: String? = null,
) {
    fun isValid(): Boolean {
        return id == null && nama == null && kontak == null &&
                alamat  == null
    }
}

fun SuplierEvent.toSuplierEntity(): Suplier = Suplier (
    id = id,
    nama = nama,
    kontak = kontak,
    alamat = alamat,
)

data class SuplierEvent(
    val id: Int = 0,
    val nama: String = "",
    val kontak: Int = 0,
    val alamat: String = "",
)