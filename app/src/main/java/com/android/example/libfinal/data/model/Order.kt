package com.android.example.libfinal.data.model

import android.os.Parcelable

@Parcelize
data class Order(
    val user_id: String = "",
    val items: @RawValue ArrayList<CartItem> = ArrayList(),
    val address: Address = Address(),
    val title: String = "",
    val image: String = "",
    val sub_total_amount: String = "",
    val shipping_charge: String = "",
    val total_amount: String = "",
    val orderDateTime: Long = System.currentTimeMillis(),
    var id: String = ""
) : Parcelable
