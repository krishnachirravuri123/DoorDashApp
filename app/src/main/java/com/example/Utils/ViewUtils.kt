package com.example.Utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.addPagination(offset: Int, totalCount: Int,limit: Int, onPaginate: (nextPage: Int) -> Unit) {

    var isLoading = false

    clearOnScrollListeners()
    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if (dy > 0) {
                if (!isLoading && (offset <= totalCount.minus(limit))) {

                    val visibleItemCount = layoutManager?.childCount ?: 0
                    val totalItemCount = layoutManager?.itemCount ?: 0
                    val firstVisibleItemPosition =
                        (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                    if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= limit
                    ) {
                        onPaginate(offset + limit)
                        isLoading = true
                    }
                }
            }
        }
    })
}