package com.forest.forestmaker.admin.network

import com.forest.forestmaker.admin.data.AdminListResponse
import com.forest.forestmaker.admin.data.SignInResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {

    @POST("/admin_list")
    fun requestAdminList(@Body body:JsonObject):Call<ArrayList<AdminListResponse>>

    @POST("/admin_ok")
    fun requestAdminOk(@Body body: JsonObject): Call<String>

    @POST("/admin_login")
    fun requestSignIn(@Body body:JsonObject): Call<SignInResponse>
}