package com.example.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by umiterkan on 1/3/2021
 */

@Parcelize
data class Repo(
    val id: String?,
    var name: String?,
    val owner: Owner?,
    val stargazers_count: Int,
    val open_issues: Int,
    var is_favorite:Boolean
):Parcelable