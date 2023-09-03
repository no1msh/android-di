package woowacourse.shopping.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import woowacourse.shopping.ShoppingApplication
import woowacourse.shopping.common.CommonViewModelFactory
import woowacourse.shopping.model.Product
import woowacourse.shopping.repository.CartRepository
import woowacourse.shopping.repository.ProductRepository

class MainViewModel(
    private val productRepositoryImpl: ProductRepository,
    private val cartRepositoryImpl: CartRepository,
) : ViewModel() {

    private val _products: MutableLiveData<List<Product>> = MutableLiveData(emptyList())
    val products: LiveData<List<Product>> get() = _products

    private val _onProductAdded: MutableLiveData<Boolean> = MutableLiveData(false)
    val onProductAdded: LiveData<Boolean> get() = _onProductAdded

    fun addCartProduct(product: Product) {
        cartRepositoryImpl.addCartProduct(product)
        _onProductAdded.value = true
    }

    fun getAllProducts() {
        _products.value = productRepositoryImpl.getAllProducts()
    }

    companion object {
        fun getViewModelFactory() = CommonViewModelFactory(MainViewModel::class.java) {
            MainViewModel(
                productRepositoryImpl = ShoppingApplication.appContainer.productRepository,
                cartRepositoryImpl = ShoppingApplication.appContainer.cartRepository,
            )
        }
    }
}
