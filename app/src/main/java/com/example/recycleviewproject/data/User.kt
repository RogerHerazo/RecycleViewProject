package com.example.recycleviewproject.data
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val nombre: String,
                val apellido: String) : Parcelable{
}