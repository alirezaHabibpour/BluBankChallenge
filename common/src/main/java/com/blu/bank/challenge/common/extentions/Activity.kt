package com.blu.bank.challenge.common.extentions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import org.koin.android.ext.android.getKoin
import org.koin.android.viewmodel.ViewModelParameters
import org.koin.android.viewmodel.ViewModelStoreOwnerDefinition
import org.koin.android.viewmodel.getViewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import kotlin.reflect.KClass


fun <T : ViewModel> AppCompatActivity.getSharedViewModel(
    clazz: KClass<T>,
    qualifier: Qualifier? = null,
    from: ViewModelStoreOwnerDefinition = { this as ViewModelStoreOwner },
    parameters: ParametersDefinition? = null
): T {
    return getKoin().getViewModel(
        ViewModelParameters(
            clazz,
            this@getSharedViewModel,
            qualifier,
            from,
            parameters
        )
    )
}


