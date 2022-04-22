package com.blu.bank.challenge.app

import com.blu.bank.challenge.common.di.*
import org.koin.core.qualifier.named
import org.koin.dsl.module



val appModule = module {

    single(named(APP_BASE_URL)) { "http://api.bluBank.com" }

    single(named(APP_NETWORK_TIMEOUT)) { 30000 }

    single(named(APP_PREFERENCES_NAME)) {  "APP_PREFERENCES"}

}



