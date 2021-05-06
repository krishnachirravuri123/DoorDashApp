package com.example.restaurants.view

import com.example.restaurants.model.Stores


interface OnRestaurantClickListener {
    fun onRestaurantClicked(store: Stores)
}