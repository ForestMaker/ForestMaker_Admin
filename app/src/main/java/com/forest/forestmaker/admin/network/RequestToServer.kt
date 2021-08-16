package com.forest.forestmaker.admin.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RequestToServer {
    var BASE_URL = "http://211.208.228.52:9872"

    val gson: Gson = GsonBuilder().setLenient().create()

    var retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(clientBuilder.build())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

    var service: RequestInterface = retrofit.create(RequestInterface::class.java)

}