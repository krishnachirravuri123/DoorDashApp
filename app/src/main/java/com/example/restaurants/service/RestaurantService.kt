package com.example.restaurants.service

import com.example.base.RetrofitConfig
import com.example.restaurants.model.RestaurantDetailModel
import com.example.restaurants.model.Restaurants
import javax.inject.Inject


class RestaurantService @Inject constructor(private val retrofitConfig: RetrofitConfig) {

    suspend fun getRestaurantList(limit: Int, offset: Int):  Restaurants{
        return retrofitConfig.getApiInterface().getRestaurantList(limit, offset)
    }

    suspend fun getRestaurant(id: Int) : RestaurantDetailModel {
        return retrofitConfig.getApiInterface().getRestaurant(id)
    }
}