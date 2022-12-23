package com.kamrulhasan.navigationcomponentdemo2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Trainee(
    val firstName: String,
    val lastName: String,
    val id: Int
): Parcelable