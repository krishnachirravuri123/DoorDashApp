package com.example.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.model.ApiResult
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


open class BaseViewModel: ViewModel() {
    protected fun <T> createMutableLiveData(): LiveData<T> = MutableLiveData()

    // used to determine the api failures
    val dataErrorStateLiveData = createMutableLiveData<ApiResult.Error?>()

    protected fun <T> LiveData<T>.postValue(value: T) {
        when (this) {
            is MutableLiveData<T> -> postValue(value)
            else -> throw Exception("Not using createMutableLiveData() or createSingleLiveData() to create live data")
        }
    }

    /**
     * Using this function to call suspend functions within the coroutine scope
     */
    fun <T> runSuspendFunction(block: suspend CoroutineScope.() -> T, errorCallback: ((ApiResult.Error) -> Unit)? = null) {

        val coroutineExceptionHanlder = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
            errorCallback?.invoke(ApiResult.Error(throwable))
        }
        viewModelScope.launch(coroutineExceptionHanlder) {
            val asyncJob = async {
                block()
            }
            asyncJob.await()
        }
    }
}