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

@BindingAdapter("restaurantImage")
fun ImageView.showRestaurantImage(url: String?) {
    if (!url.isNullOrEmpty())
        Picasso.get().load(url).into(this)
}

@BindingAdapter("restaurantName")
fun AppCompatTextView.showRestaurantName(name: String?) {
    text = name ?: ""
}

@BindingAdapter("restaurantCuisine")
fun AppCompatTextView.showRestaurantDesc(desc: String?) {
    text = desc ?: ""
}

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

@BindingAdapter("menuTags")
fun AppCompatTextView.showMenuTags(detailModel: RestaurantDetailModel?) {
    if (detailModel != null) {
        text = detailModel.tags?.joinToString { it ->
            "\'${it}\'"
        }
    }
}

@BindingAdapter("address")
fun AppCompatTextView.showAddress(detailModel: RestaurantDetailModel?) {
    if (detailModel != null) {
        text = detailModel.address?.printableAddress ?: ""
    }
}
