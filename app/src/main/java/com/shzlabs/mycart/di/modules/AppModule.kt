package com.shzlabs.mycart.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.shzlabs.mycart.NavMgr
import com.shzlabs.mycart.R
import com.shzlabs.mycart.util.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Provides
    fun getString(): String {
        return application.getString(R.string.app_name)
    }

    @Provides
    fun getContext(): Context {
        return application
    }

    @Singleton
    @Provides
    fun getNavMgr(): NavMgr {
        return NavMgr()
    }

    @Singleton
    @Provides
    fun getSharedPrefs(): SharedPreferences {
        return application.getSharedPreferences(Constants.SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    }

}