package com.shzlabs.mycart.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shzlabs.mycart.ui.cart.CartViewModel
import com.shzlabs.mycart.ui.confirmation.OrderConfirmationViewModel
import com.shzlabs.mycart.ui.main.MainViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class ViewModelFactory @Inject constructor (val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return creators[modelClass]?.get() as T
    }

}

@Module
internal abstract class ViewModelBuilder {
    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory


    // Add all ViewModels here

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    internal abstract fun cartViewModel(cartViewModel: CartViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OrderConfirmationViewModel::class)
    internal abstract fun orderConfirmationViewModel(orderConfirmationViewModel: OrderConfirmationViewModel) : ViewModel


}

@Target(
    AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)