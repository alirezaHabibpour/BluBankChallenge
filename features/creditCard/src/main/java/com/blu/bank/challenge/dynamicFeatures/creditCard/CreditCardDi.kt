package com.blu.bank.challenge.dynamicFeatures.creditCard

import com.blu.bank.challenge.common.di.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module


fun injectLoginFeature() = loadCreditCardModule
private val loadCreditCardModule by lazy {
    loadKoinModules(creditCardModule)
}

val creditCardModule= module {


    //config preferences di


    //config repository di
    single<CreditCardRepository> { CreditCardRepositoryImpl(createNetwork(CreditCardNetwork::class.java,get(named(
        MOCK_SERVER_RETROFIT))))}

    //config viewModel di
    viewModel { CreditCardViewModel(get()) }
}