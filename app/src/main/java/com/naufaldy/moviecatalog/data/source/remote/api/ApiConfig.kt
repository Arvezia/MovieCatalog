package com.naufaldy.moviecatalog.data.source.remote.api

import com.naufaldy.moviecatalog.BuildConfig
import com.naufaldy.moviecatalog.data.source.remote.api.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    private val client = OkHttpClient.Builder().apply {}.build()

    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder().apply {
            client(client)
            baseUrl(BuildConfig.BASE_URL_TMDB)
            addConverterFactory(GsonConverterFactory.create())
        }
    }

    val instance: ApiService by lazy {
        retrofit.build().create(ApiService::class.java)
    }

}