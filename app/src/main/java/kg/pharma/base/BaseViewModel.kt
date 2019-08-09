package kg.pharma.base

import android.arch.lifecycle.ViewModel
import kg.pharma.ui.register.confirm_code.ConfirmCodeViewModel
import kg.pharma.injection.component.DaggerViewModelInjector
import kg.pharma.injection.component.ViewModelInjector
import kg.pharma.injection.module.NetworkModule
import kg.pharma.post.PostListViewModel
import kg.pharma.post.PostViewModel
import kg.pharma.product.ProductListViewModel
import kg.pharma.product.ProductViewModel
import kg.pharma.ui.register.RegisterViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)

            is ProductListViewModel -> injector.inject(this)
            is ProductViewModel -> injector.inject(this)
            is ConfirmCodeViewModel -> injector.inject(this)
            is RegisterViewModel -> injector.inject(this)
        }
    }
}