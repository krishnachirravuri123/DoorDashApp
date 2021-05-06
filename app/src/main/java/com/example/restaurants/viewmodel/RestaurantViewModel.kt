package com.example.restaurants.viewmodel

import com.example.base.BaseViewModel
import com.example.restaurants.model.Restaurants
import com.example.restaurants.service.RestaurantService
import javax.inject.Inject


class RestaurantViewModel @Inject constructor(private val restaurantService: RestaurantService) : BaseViewModel(){

    val restaurantsLiveData = createMutableLiveData<Restaurants>()

    val noResults  = createMutableLiveData<Boolean>()

    val isLoading = createMutableLiveData<Boolean>()


    /**
     * Gets the list of restaurants with specified limit and offset
     */
    fun getRestaurants(limit: Int, offset: Int?) {

        isLoading.postValue(true)
        runSuspendFunction({

            if(limit >= 0 && offset != null){
                val response = restaurantService.getRestaurantList(limit, offset)

                isLoading.postValue(false)

                if(!response.stores.isNullOrEmpty()) {
                    restaurantsLiveData.postValue(response)
                } else {
                    noResults.postValue(true)
                }
            }
        },  {
            isLoading.postValue(false)
            dataErrorStateLiveData.postValue(it)
        })
    }

}