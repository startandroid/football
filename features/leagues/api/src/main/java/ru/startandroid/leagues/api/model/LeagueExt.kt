package ru.startandroid.leagues.api.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LeagueExt(
    val id: Int,
    val name: String,
): Parcelable