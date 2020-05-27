package com.agisti.submissionfundamental1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var avatar: Int,
    var name: String,
    var username: String,
    var company: String,
    var location : String,
    var follower: String,
    var following: String,
    var repository: String
):Parcelable
