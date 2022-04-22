package com.blu.bank.challenge.common.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val APP_PREFERENCES ="APP_PREFERENCES"
const val APP_PREFERENCES_NAME ="APP_PREFERENCES_NAME"




val preferenceModule = module {
    single (named(APP_PREFERENCES)){ providePreferences(get(),get(named(APP_PREFERENCES_NAME))) }
}

fun providePreferences(context: Context,preferenceName:String) : SharedPreferences? {
    return context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
}
