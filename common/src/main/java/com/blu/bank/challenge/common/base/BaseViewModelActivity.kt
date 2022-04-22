package com.blu.bank.challenge.common.base

import com.blu.bank.challenge.common.extentions.getSharedViewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass


abstract class BaseViewModelActivity<M : BaseViewModel> : BaseActivity() {

    val viewModel: M by lazy { getSharedViewModel(viewModelClass()) }



    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass(): KClass<M> {
        // dirty hack to get generic type https://stackoverflow.com/a/1901275/719212
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<M>).kotlin


    }


}
