package com.forest.forestmaker.admin.data

data class ReceiptData(
    val _id: String,
    val date: String,
    val time: String,
    val tree: String,
    val location: String,
    val plantDate: String,
    val product: String?,
    var status: Int
)