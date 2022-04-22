package com.blu.bank.challenge.dynamicFeatures.creditCard

import retrofit2.Response
import retrofit2.http.GET


interface CreditCardNetwork {

    @GET("/v1/getCardDetails")
    suspend fun getCardDetails( ): Response<CardDetailResponseDto>

}