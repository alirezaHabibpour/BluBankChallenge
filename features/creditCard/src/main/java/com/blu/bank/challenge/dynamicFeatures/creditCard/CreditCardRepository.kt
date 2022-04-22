package com.blu.bank.challenge.dynamicFeatures.creditCard

import com.blu.bank.challenge.common.base.BaseRepositoryDelegation
import com.blu.bank.challenge.common.exception.Failure
import com.blu.bank.challenge.common.util.Either


interface CreditCardRepository {

    suspend fun  getCardDetails():Either<Failure,CardDetailResponseDto>

}

class CreditCardRepositoryImpl(
    private val network: CreditCardNetwork,
) : BaseRepositoryDelegation(), CreditCardRepository {
    override suspend fun getCardDetails(): Either<Failure, CardDetailResponseDto> {
        return networkRequest({ network.getCardDetails() }, { it }, CardDetailResponseDto.default())
    }


}