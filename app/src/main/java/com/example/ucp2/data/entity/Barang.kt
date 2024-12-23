package com.example.ucp2.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "barang",
        foreignKeys = [
            ForeignKey(
                entity = Suplier::class,
                parentColumns = ["nama"],
                childColumns = ["namaSuplier"],
                onDelete = ForeignKey.CASCADE
            )
        ]
)

data class Barang(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nama: String,
    val deskripsi: String,
    val harga: Double,
    val stok: Int,
    val namaSuplier: String
)
