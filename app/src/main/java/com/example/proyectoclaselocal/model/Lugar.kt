package com.example.proyectoclaselocal.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "lugar")
data class Lugar(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "correo")
    val correo: String?,
    @ColumnInfo(name = "telefono")
    val telefono: String?,
    @ColumnInfo(name = "web")
    val web: String? //? = permite el manejo de nulos
) : Parcelable
