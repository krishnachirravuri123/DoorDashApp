package com.example.restaurants.viewmodel

import com.example.base.BaseViewModel
import com.example.restaurants.model.RestaurantDetailModel
import com.example.restaurants.model.Restaurants
import com.example.restaurants.model.Stores
import com.example.restaurants.service.RestaurantService
import javax.inject.Inject


class RestaurantDetailViewModel @Inject constructor(private val restaurantService: RestaurantService) : BaseViewModel(){

    val storeLiveData = createMutableLiveData<RestaurantDetailModel>()

    val isLoading = createMutableLiveData<Boolean>()

    /**
     * Gets the restaurant based on the input id
     */
    fun getStore(id: Int) {

        isLoading.postValue(true)
        runSuspendFunction({

            if(id != 0){
                val response = restaurantService.getRestaurant(id)

                isLoading.postValue(false)

                if(response.id != 0) {
                    storeLiveData.postValue(response)
                }
            }
        },  {
            isLoading.postValue(false)
            dataErrorStateLiveData.postValue(it)
        })
    }
}