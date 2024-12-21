package com.example.ucp2.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "suplier", indices = [Index(value = ["nama"], unique = true)])
data class Suplier(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nama: String,
    val kontak: Int,
    val alamat: String
)
