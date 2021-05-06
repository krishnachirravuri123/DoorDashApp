package com.example.restaurants.adapter

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.example.restaurants.model.RestaurantDetailModel
import com.example.restaurants.model.Stores
import com.squareup.picasso.Picasso
import java.time.LocalDateTime

/**
 * used to set the view data from using data binding
 */

// Binds the image for the restaurant
@BindingAdapter("restaurantImage")
fun ImageView.showRestaurantImage(url: String?) {
    if (!url.isNullOrEmpty())
        Picasso.get().load(url).into(this)
}

// Binds the restaurant name
@BindingAdapter("restaurantName")
fun AppCompatTextView.showRestaurantName(name: String?) {
    text = name ?: ""
}

// Binds the restaurant description
@BindingAdapter("restaurantCuisine")
fun AppCompatTextView.showRestaurantDesc(desc: String?) {
    text = desc ?: ""
}

// Binds the restaurant status
@BindingAdapter("restaurantStatus")
fun AppCompatTextView.showRestaurantStatus(store: Stores?) {
    if (store != null) {
        text =
            if (!store.nextCloseTime.isNullOrEmpty() && store.nextCloseTime ?: "" > LocalDateTime.now()
                    .toString()
            ) {
                "${store.status?.asapMinutesRange?.getOrNull(0)} ${"Mins"}"
            } else "Closed"
    }
}

// Binds the menu Tags
@BindingAdapter("menuTags")
fun AppCompatTextView.showMenuTags(detailModel: RestaurantDetailModel?) {
    if (detailModel != null) {
        text = detailModel.tags?.joinToString { it ->
            "\'${it}\'"
        }
    }
}

// Binds the address
@BindingAdapter("address")
fun AppCompatTextView.showAddress(detailModel: RestaurantDetailModel?) {
    if (detailModel != null) {
        text = detailModel.address?.printableAddress ?: ""
    }
}
