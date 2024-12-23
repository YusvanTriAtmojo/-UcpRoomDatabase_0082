package com.example.ucp2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2.data.dao.BarangDao
import com.example.ucp2.data.dao.SuplierDao
import com.example.ucp2.data.entity.Barang
import com.example.ucp2.data.entity.Suplier

@Database(entities = [Barang::class, Suplier::class], version = 1, exportSchema = false)
abstract class InvtDatabase : RoomDatabase(){
    abstract fun barangDao(): BarangDao
    abstract fun suplierDao(): SuplierDao

    companion object {
        @Volatile
        private var Instance: InvtDatabase? = null

        fun getDatabase(context: Context): InvtDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    InvtDatabase::class.java,
                    "InvtDatabase"
                )
                    .build().also { Instance = it }
            })
        }
    }
}