package kg.pharma.injection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import kg.pharma.ui.register.confirm_code.ConfirmCodeViewModel
import kg.pharma.post.PostListViewModel
import kg.pharma.product.ProductListViewModel
import kg.pharma.ui.register.RegisterViewModel

class ViewModelFactory(): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PostListViewModel() as T
        }
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductListViewModel() as T
        }
        if (modelClass.isAssignableFrom(ConfirmCodeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ConfirmCodeViewModel() as T
        }
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RegisterViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}