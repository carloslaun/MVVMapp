package com.example.mvvmapp.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/"
    private val logger: OkHttpClient
    get() {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val HttpClient = OkHttpClient.Builder()
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
        //if(BuildConfig) HttpClient.interceptors().add(logging)
        return HttpClient.build()
    }
    val getClient: Retrofit?
    get() {
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(logger)
                .build()

        }
        return retrofit
    }
}