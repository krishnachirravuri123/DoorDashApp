package com.example.restaurants.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.base.view.BaseActivity
import com.example.dagger.viewmodel.ViewModelProviderFactory
import com.example.restaurants.R
import com.example.restaurants.databinding.RestaurantDetailBinding
import com.example.restaurants.viewmodel.RestaurantDetailViewModel
import javax.inject.Inject


class RestaurantDetailActivity: BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val id: Int by lazy {
        return@lazy intent.getIntExtra("STORE_ID", 0)
    }


    private val viewBinding: RestaurantDetailBinding by lazy {
        DataBindingUtil.setContentView<RestaurantDetailBinding>(this, R.layout.restaurant_detail).apply {
            lifecycleOwner = this@RestaurantDetailActivity
            detailViewModel = restaurantDetailViewModel
        }
    }

    private val restaurantDetailViewModel by viewModels<RestaurantDetailViewModel> { viewModelFactory }
    override fun constructComponentBuilder() {
        applicationComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(id != 0)
        restaurantDetailViewModel.getStore(id)

        setSupportActionBar(viewBinding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        restaurantDetailViewModel.isLoading.observe(this) { isLoading ->
            if(isLoading) viewBinding.progressBar.visibility = View.VISIBLE else viewBinding.progressBar.visibility = View.GONE
        }

        restaurantDetailViewModel.storeLiveData.observe(this) {
            viewBinding.menuHeader.visibility = View.VISIBLE
            viewBinding.addressHeader.visibility = View.VISIBLE
        }

        restaurantDetailViewModel.dataErrorStateLiveData.observe(this) {
            viewBinding.restaurantDesc.visibility = View.GONE
            viewBinding.restaurantImage.visibility = View.GONE
            viewBinding.menuHeader.visibility = View.GONE
            viewBinding.menuTags.visibility =  View.GONE
            viewBinding.errorView.visibility = View.VISIBLE
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        super.onBackPressed()
        return true
    }

}