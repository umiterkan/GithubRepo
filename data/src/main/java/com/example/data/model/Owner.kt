package com.example.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

/**
 * Created by umiterkan on 1/3/2021
 */

@Parcelize
class Owner(val id: String?, val login: String?, val avatar_url: String?) : Parcelable


@Parcelize
class User(val firstName: String, val lastName: String): Parcelable