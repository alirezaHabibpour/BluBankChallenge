package com.blu.bank.challenge.common.di

import android.content.Context
import android.content.res.Resources
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val APP_RESOURCES ="APP_RESOURCES"


val resourcesModule = module {
    single (named(APP_RESOURCES)){ proviceResources(get()) }
}

fun proviceResources(context: Context) : Resources? {
    return context.resources
}
