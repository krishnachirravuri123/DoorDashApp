package com.example.restaurants.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Utils.addPagination
import com.example.base.view.BaseActivity
import com.example.dagger.viewmodel.ViewModelProviderFactory
import com.example.restaurants.BuildConfig
import com.example.restaurants.R
import com.example.restaurants.adapter.RestaurantAdapter
import com.example.restaurants.databinding.ActivityMainBinding
import com.example.restaurants.model.Stores
import com.example.restaurants.viewmodel.RestaurantViewModel
import java.util.*
import javax.inject.Inject


const val STORE_ID = "STORE_ID"

class RestaurantListActivity : BaseActivity(), OnRestaurantClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val adapter: RestaurantAdapter by lazy {
        return@lazy RestaurantAdapter(this)
    }

    private var offset: Int = 0


    private val viewBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@RestaurantListActivity
        }
    }

    private val restaurantsViewModel by viewModels<RestaurantViewModel> { viewModelFactory }
    override fun constructComponentBuilder() {
        applicationComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.toolbar.title = getString(R.string.discover)

        restaurantsViewModel.getRestaurants(BuildConfig.PAGE_LIMIT, offset)

        restaurantsViewModel.restaurantsLiveData.observe(this) { restaurants ->
            viewBinding.restaurantRecyclerView.visibility = View.VISIBLE
            restaurants.stores?.let { stores ->
                restaurants.nextOffset?.let {
                    setAdapter(
                        storeList = stores,
                        totalCount = restaurants.numResults ?: 0,
                        offset = offset
                    ) { page ->
                        restaurantsViewModel.getRestaurants(
                            BuildConfig.PAGE_LIMIT,
                            offset = page
                        )
                    }
                }
            }

        }

        setOrientation()
        viewBinding.restaurantRecyclerView.adapter = adapter

        setVisibilityForItems()

    }

    /**
     * sets the orientation and adds divider for the recycler view
     */
    private fun setOrientation() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        viewBinding.restaurantRecyclerView.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(
            viewBinding.restaurantRecyclerView.context,
            layoutManager.orientation
        )
        viewBinding.restaurantRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    /**
     *  sets the visibility based on the API response
     */
    private fun setVisibilityForItems() {
        restaurantsViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) viewBinding.progressBar.visibility =
                View.VISIBLE else viewBinding.progressBar.visibility = View.GONE
        }

        restaurantsViewModel.noResults.observe(this) { noResults ->
            if (noResults) {
                viewBinding.restaurantRecyclerView.visibility = View.GONE
                viewBinding.noResultsView.visibility = View.VISIBLE
            } else {
                viewBinding.restaurantRecyclerView.visibility = View.VISIBLE
                viewBinding.noResultsView.visibility = View.GONE
            }
        }

        restaurantsViewModel.dataErrorStateLiveData.observe(this) {
            viewBinding.restaurantRecyclerView.visibility = View.GONE
            viewBinding.errorView.visibility = View.VISIBLE
        }
    }

    /**
     *   sets the adapter with the plans and pagination
     */
    private fun setAdapter(
        storeList: ArrayList<Stores>,
        totalCount: Int,
        offset: Int,
        serviceCall: ((nextPage: Int) -> Unit?)? = null
    ) {
        adapter.setData(storeList, offset)
        viewBinding.restaurantRecyclerView.addPagination(
            offset,
            totalCount,
            BuildConfig.PAGE_LIMIT
        ) { nextPage ->
            this.offset = nextPage
            serviceCall?.invoke(nextPage)
        }
    }

    // navigate to restaurant detail on item clicked
    override fun onRestaurantClicked(store: Stores) {

        val intent = Intent(this, RestaurantDetailActivity::class.java).apply {
            putExtra(STORE_ID, store.id)
        }
        startActivity(intent)

    }
}