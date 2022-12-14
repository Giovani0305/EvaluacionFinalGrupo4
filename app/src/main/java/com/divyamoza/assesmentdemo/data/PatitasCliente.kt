package com.divyamoza.assesmentdemo.data

import com.divyamoza.assesmentdemo.utils.Constantes
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object PatitasCliente {

    private var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.MINUTES)
        .writeTimeout(15, TimeUnit.MINUTES)
        //.addInterceptor(ApiInterceptor())
        .build()

    private fun buidRetrofit() = Retrofit.Builder()
        .baseUrl(Constantes().API_PATITAS_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: PatitasServicio by lazy {
        buidRetrofit().create(PatitasServicio::class.java)
    }
}