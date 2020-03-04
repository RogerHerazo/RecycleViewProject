package com.example.recycleviewproject.data
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val titulo: String,
                val nombre: String,
                val apellido: String,
                val mail: String,
                val phone:String) : Parcelable{
}