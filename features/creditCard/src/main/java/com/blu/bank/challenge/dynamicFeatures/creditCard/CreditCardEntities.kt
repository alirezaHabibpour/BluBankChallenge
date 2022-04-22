package com.blu.bank.challenge.dynamicFeatures.creditCard

import com.blu.bank.challenge.common.base.BaseResponseModel


data class  CardDetailResponseDto(
    val cardNumber:String?,val expDate:String?, val cvv2:String?, val cardOwnerFirstName:String?, val cardOwnerLastName:String?
):BaseResponseModel(){

    companion object{
        fun default() :CardDetailResponseDto = CardDetailResponseDto(null,null,null,null,null)
    }
}
