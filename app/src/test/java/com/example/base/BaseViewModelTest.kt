package com.example.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Rule
import org.mockito.Mockito


@ExperimentalCoroutinesApi
open class BaseViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @After
    fun afterEachTest() {
        Mockito.validateMockitoUsage()
    }
}