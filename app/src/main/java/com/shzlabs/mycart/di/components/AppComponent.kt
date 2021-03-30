package com.shzlabs.mycart.di.components

import android.app.Application
import com.shzlabs.mycart.ui.main.MainActivity
import com.shzlabs.mycart.di.ViewModelBuilder
import com.shzlabs.mycart.di.modules.AppModule
import com.shzlabs.mycart.di.modules.NetworkModule
import com.shzlabs.mycart.ui.cart.CartFragment
import com.shzlabs.mycart.ui.confirmation.OrderConfirmationFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ViewModelBuilder::class])
interface AppComponent {

    fun application(application: Application)
    fun inject(mainActivity: MainActivity)
    fun inject(cartFragment: CartFragment)
    fun inject(orderConfirmationFragment: OrderConfirmationFragment)

}