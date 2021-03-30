package com.shzlabs.mycart

import android.app.Application
import com.shzlabs.mycart.di.components.AppComponent
import com.shzlabs.mycart.di.components.DaggerAppComponent
import com.shzlabs.mycart.di.modules.AppModule

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent.application(this)
    }

}