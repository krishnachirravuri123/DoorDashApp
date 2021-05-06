package com.example.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.restaurants.viewmodel.RestaurantViewModel
import com.example.dagger.viewmodel.ViewModelKey
import com.example.dagger.viewmodel.ViewModelProviderFactory
import com.example.restaurants.viewmodel.RestaurantDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * used to provide the view model instance using dagger
 */
@Module
abstract class ViewModelFactoryModule {


    @Binds
    @IntoMap
    @ViewModelKey(RestaurantViewModel::class)
    // Bind your View Model here
    abstract fun bindMainViewModel(restaurantViewModel: RestaurantViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RestaurantDetailViewModel::class)
    // Bind your View Model here
    abstract fun bindDetailViewModel(restaurantDetailViewModel: RestaurantDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory):
            ViewModelProvider.Factory

}