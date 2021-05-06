package com.example.base


import com.example.restaurants.BuildConfig
import retrofit2.Retrofit


class RetrofitConfig() {


    private lateinit  var retrofit: Retrofit


    constructor(retrofit: Retrofit) : this() {
        this.retrofit = retrofit
    }


    /**
     * creates the Api Interface with the endpoint base url
     */
    fun getApiInterface(): ApiInterface {
        return retrofit.newBuilder().baseUrl(BuildConfig.DOOR_DASH_URL)
            .build().create(ApiInterface::class.java)
    }

}