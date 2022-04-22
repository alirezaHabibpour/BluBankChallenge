package com.blu.bank.challenge.app

import android.app.Application
import com.blu.bank.challenge.common.di.assetModule
import com.blu.bank.challenge.common.di.networkModule
import com.blu.bank.challenge.common.di.preferenceModule
import com.blu.bank.challenge.common.di.resourcesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BluBankApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(
                appModule,networkModule, preferenceModule,
                assetModule, resourcesModule
            ))
            androidContext(applicationContext)
        }
    }
}