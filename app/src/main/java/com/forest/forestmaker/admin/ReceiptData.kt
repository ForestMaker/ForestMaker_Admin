package com.forest.forestmaker.admin

data class ReceiptData(
    val date: String,
    val time: String,
    val tree: String,
    val location: String,
    val plantDate: String,
    val product: String?,
    var status: Boolean
)