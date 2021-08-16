package com.forest.forestmaker.admin.data

data class AdminListResponse(
    val _id: String,
    val date: String,
    val headcount: String,
    val name: String,
    val type: String,
    val address: String,
    val user: User,
    val payment:Payment,
    val finalmile: Int,
    val state: Int
)

data class User(
    val user_name: String,
    val user_phone: String,
    val user_id: String
)

data class Payment(
    val item: String,
    val item_count: Int,
    val total_count: Int,
    val total_price: String,
    val use_mileage: Int,
    val real_total_price: String
)