package woowacourse.shopping.dimodule

import android.content.Context
import com.bandal.fullmoon.FullMoonInject
import com.bandal.halfmoon.AndroidDependencyModule
import woowacourse.shopping.ui.cart.DateFormatter
import javax.inject.Singleton

class CartActivityModule : AndroidDependencyModule {

    override var context: Context? = null

    @Singleton
    fun provideDateFormatter(
        @FullMoonInject
        context: Context,
    ) = DateFormatter(context)

    fun provideContext(): Context = context!!
}
