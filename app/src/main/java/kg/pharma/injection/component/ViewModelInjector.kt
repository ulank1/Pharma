package kg.pharma.injection.component

import dagger.Component
import kg.pharma.ui.register.confirm_code.ConfirmCodeViewModel
import kg.pharma.injection.module.NetworkModule
import kg.pharma.post.PostListViewModel
import kg.pharma.post.PostViewModel
import kg.pharma.product.ProductListViewModel
import kg.pharma.product.ProductViewModel
import kg.pharma.ui.register.RegisterViewModel
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(postListViewModel: PostListViewModel)
    fun inject(productListViewModel: ProductListViewModel)
    /**
     * Injects required dependencies into the specified PostViewModel.
     * @param postViewModel PostViewModel in which to inject the dependencies
     */
    fun inject(postViewModel: PostViewModel)
    fun inject(productViewModel: ProductViewModel)
    fun inject(confirmCodeViewModel: ConfirmCodeViewModel)
    fun inject(registerViewModel: RegisterViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}