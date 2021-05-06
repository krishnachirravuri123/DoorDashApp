package com.example.dagger.module


import com.example.base.RetrofitConfig
import com.example.restaurants.BuildConfig
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
open class ApplicationModule {

    @Provides
    @Singleton
    fun getRetrofitConfig(retrofit: Retrofit) : RetrofitConfig {
        return RetrofitConfig(retrofit)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.DOOR_DASH_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}