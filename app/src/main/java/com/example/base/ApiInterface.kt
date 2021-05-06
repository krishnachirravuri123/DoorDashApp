package com.example.base

import com.example.restaurants.model.RestaurantDetailModel
import com.example.restaurants.model.Restaurants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {

    @GET("v1/store_feed/")
    suspend fun getRestaurantList(@Query("limit") limit: Int, @Query("offset") offset: Int, @Query("lat") lat: Double? = 37.422740, @Query("lng") lng: Double? = -122.139956): Restaurants

    @GET("v2/restaurant/{restaurant_id}")
    suspend fun getRestaurant(@Path("restaurant_id") id: Int): RestaurantDetailModel

}