package com.example.application

import android.app.Application
import com.example.dagger.component.ApplicationComponent
import com.example.dagger.component.DaggerApplicationComponent


class App: Application() {

    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}