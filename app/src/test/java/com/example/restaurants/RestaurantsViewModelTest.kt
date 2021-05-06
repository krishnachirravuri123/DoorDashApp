package com.example.restaurants

import com.example.base.BaseViewModelTest
import com.example.base.getTestValue
import com.example.base.mock
import com.example.restaurants.model.Restaurants
import com.example.restaurants.model.Stores
import com.example.restaurants.service.RestaurantService
import com.example.restaurants.viewmodel.RestaurantViewModel
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.lang.NullPointerException


@ExperimentalCoroutinesApi
open class RestaurantsViewModelTest: BaseViewModelTest() {

    private lateinit var restaurantService: RestaurantService

    private val restaurantsViewModel: RestaurantViewModel by lazy {
        RestaurantViewModel(restaurantService)
    }

    @Before
    fun setUp() {
       restaurantService = mock()
    }

    private fun getRestaurants(): Restaurants {

        return Restaurants().apply {
            numResults = 100
            nextOffset= 20
            stores = arrayListOf<Stores>().apply {
                add(Stores().apply {
                    name = "The Melt"
                    description = "This has all the american items"
                    distanceFromConsumer = 3.343443
                })
                add(Stores().apply {
                    name = "Starbucks"
                    description = "This has all the coffee and sandwiches"
                    distanceFromConsumer = 2.343443
                })
            }
        }
    }

    private fun getRestaurantsEmptyList(): Restaurants {

        return Restaurants().apply {
            numResults = 100
            nextOffset= 20
            stores = arrayListOf()
        }
    }


    @Test
    fun getRestaurantsSuccess() {

        val restaurants = getRestaurants()

        runBlockingTest{

            Mockito.`when`(restaurantService.getRestaurantList(10, 0)).thenReturn(restaurants)

            restaurantsViewModel.getRestaurants(10, 0)

            val restaurantsTestValue =  restaurantsViewModel.restaurantsLiveData.getTestValue()

            val errorValue =  restaurantsViewModel.dataErrorStateLiveData.getTestValue()

            TestCase.assertNotNull(restaurantsTestValue)

            TestCase.assertNull(errorValue)
        }

    }

    @Test
    fun getRestaurntsWithEmptyList() {

        val restaurants = getRestaurantsEmptyList()

        runBlockingTest {
            Mockito.`when`(restaurantService.getRestaurantList(10, 0)).thenReturn(restaurants)

            restaurantsViewModel.getRestaurants(10, 0)

            val emptyStateData =  restaurantsViewModel.noResults.getTestValue()

            val errorValue =  restaurantsViewModel.dataErrorStateLiveData.getTestValue()

            TestCase.assertNotNull(emptyStateData)

            TestCase.assertNull(errorValue)
        }

    }

    @Test
    fun getRestaurantsWithError() {


        runBlockingTest {
            Mockito.`when`(restaurantService.getRestaurantList(10, 0)).thenThrow(NullPointerException())

            restaurantsViewModel.getRestaurants(10, 0)

            val errorValue =  restaurantsViewModel.dataErrorStateLiveData.getTestValue()

            TestCase.assertNotNull(errorValue)
        }

    }

    @Test
    fun getRestaurantsWitInvalidLimit() {


        runBlockingTest {

            restaurantsViewModel.getRestaurants(-1, 0)

            Mockito.verify(restaurantService, Mockito.times(0)).getRestaurantList(-1, 0)
        }

    }


}