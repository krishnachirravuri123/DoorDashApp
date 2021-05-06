package com.example.dagger.component

import com.example.dagger.module.ApplicationModule
import com.example.dagger.module.ViewModelFactoryModule
import com.example.restaurants.view.RestaurantDetailActivity
import com.example.restaurants.view.RestaurantListActivity
import dagger.Component
import javax.inject.Singleton

/**
 * inject the app's required activities or objects to resolve the dependencies
 */
@Singleton
@Component(modules = [ApplicationModule::class, ViewModelFactoryModule::class])
interface ApplicationComponent {

    fun inject(restaurantListActivity: RestaurantListActivity)

    fun inject(restaurantDetailActivity: RestaurantDetailActivity)
}