package com.example.restaurants

import com.example.base.BaseViewModelTest
import com.example.base.getTestValue
import com.example.base.mock
import com.example.restaurants.model.RestaurantDetailModel
import com.example.restaurants.service.RestaurantService
import com.example.restaurants.viewmodel.RestaurantDetailViewModel
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import java.lang.NullPointerException


@ExperimentalCoroutinesApi
class RestaurantDetailViewModelTest: BaseViewModelTest() {

    private lateinit var restaurantService: RestaurantService

    private val restaurantDetailViewModel: RestaurantDetailViewModel by lazy {
        RestaurantDetailViewModel(restaurantService)
    }

    @Before
    fun setUp() {
        restaurantService = mock()
    }

    private fun getRestaurantDetail(): RestaurantDetailModel {

        return RestaurantDetailModel().apply {
            description = "L&L Hawaiian Barbecue"
            coverImgUrl = "\"https://cdn.doordash.com/media/restaurant/cover/LLHawaiianBBQ_5752105_Las_Vegas_NV.png\""
            name = "L&L Hawaiian BBQ (El Camino Real)"
        }
    }


    @Test
    fun getRestaurantDetailSuccess() {

        val restaurants = getRestaurantDetail()

        runBlockingTest{

            Mockito.`when`(restaurantService.getRestaurant(34321)).thenReturn(restaurants)

            restaurantDetailViewModel.getStore(34321)

            val restaurantsTestValue =  restaurantDetailViewModel.storeLiveData.getTestValue()

            val errorValue =  restaurantDetailViewModel.dataErrorStateLiveData.getTestValue()

            TestCase.assertNotNull(restaurantsTestValue)

            TestCase.assertNull(errorValue)
        }

    }

    @Test
    fun getRestaurantDetailError() {

        runBlockingTest{

            Mockito.`when`(restaurantService.getRestaurant(34321)).thenThrow(NullPointerException())

            restaurantDetailViewModel.getStore(34321)

            val errorValue =  restaurantDetailViewModel.dataErrorStateLiveData.getTestValue()

            TestCase.assertNotNull(errorValue)
        }

    }
}