package com.example.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.application.App
import com.example.dagger.component.ApplicationComponent

/**
 * used to provide abstract method to inject the activity with the component
 */
abstract class
BaseActivity : AppCompatActivity() {

    lateinit var applicationComponent: ApplicationComponent


    abstract fun constructComponentBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        applicationComponent = (application as App).appComponent
        constructComponentBuilder()

    }


}