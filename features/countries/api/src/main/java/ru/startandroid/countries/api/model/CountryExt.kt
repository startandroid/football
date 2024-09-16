package ru.startandroid.countries.api.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryExt(
    val name: String,
    val code: String,
    val flag: String?
) : Parcelable