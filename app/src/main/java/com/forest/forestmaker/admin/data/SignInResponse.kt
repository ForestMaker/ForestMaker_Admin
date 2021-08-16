package com.forest.forestmaker.admin.data

data class SignInResponse(
    val message: String,
    val data: Data
)

data class Data(
    val mileage: Int,
    val treecnt: Int,
    val _id: String,
    val id: String,
    val pw: String,
    val nickname: String,
    val __v: Int
)

//    "message": "유저 찾음",
//    "data": {
//        "mileage": 1000,
//        "treecnt": 0,
//        "_id": "6119dbb62029dc2061d39cd3",
//        "id": "admin",
//        "pw": "0",
//        "nickname": "관리자",
//        "__v": 0
//    }