package com.example.restaurants.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.R
import com.example.restaurants.BR
import com.example.restaurants.databinding.RestaurantItemBinding
import com.example.restaurants.model.Stores

import com.example.restaurants.view.OnRestaurantClickListener


class RestaurantAdapter(private val clickListener: OnRestaurantClickListener) : RecyclerView.Adapter<RestaurantAdapter.RestaurantsViewHolder>(){

    private val stores: ArrayList<Stores> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<RestaurantItemBinding>(inflater, R.layout.restaurant_item, parent, false)
        return RestaurantsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val store = stores[position]
        holder.binding.setVariable(BR.restaurantItem, store)
        holder.binding.executePendingBindings()
        holder.itemView.setOnClickListener{
            clickListener.onRestaurantClicked(store)
        }
    }

    fun setData(storeList: ArrayList<Stores>, nextOffset: Int) {
        if (nextOffset == 0) {
            stores.clear()
            stores.addAll(storeList)
            notifyDataSetChanged()
        } else {
            val lastPosition = stores.size
            this.stores.addAll(storeList)
            notifyItemRangeInserted(lastPosition + 1, storeList.size)
        }
    }

    override fun getItemCount(): Int {
        return stores.size
    }

    inner class RestaurantsViewHolder(val binding: RestaurantItemBinding): RecyclerView.ViewHolder(binding.root)

}