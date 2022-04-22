package com.blu.bank.challenge.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.blu.bank.challenge.common.R
import kotlinx.android.synthetic.main.fragment_base_layout.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.getSharedViewModel
import org.koin.core.qualifier.named
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass


abstract class BaseFragment<M : BaseViewModel> : Fragment() {

    // region BASE_VARIABLES
    abstract fun layoutId(): Int

    val viewModel: M by lazy { getSharedViewModel(viewModelClass()) }
    //endregion

    //region LIFE_CYCLE
    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass(): KClass<M> {
        // dirty hack to get generic type https://stackoverflow.com/a/1901275/719212
        return ((javaClass.genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<M>).kotlin
    }



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_base_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (view.findViewById<View>(layoutId()) == null) {
            val rootView = LayoutInflater.from(activity).inflate(layoutId(), layout_main, false)
            layout_main.addView(rootView)
        }

    }


    //endregion







}



