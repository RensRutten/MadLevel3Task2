package com.example.madlevel3task2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Website(
    var TitleText: String,
    var URLtext: String
) : Parcelable
