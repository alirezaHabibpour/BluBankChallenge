package com.blu.bank.challenge.dynamicFeatures.creditCard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blu.bank.challenge.common.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreditCardViewModel(private val repository: CreditCardRepository) : BaseViewModel() {
    private val _cardDetailResult: MutableLiveData<CardDetailResponseDto> = MutableLiveData()
    val cardDetailResult: LiveData<CardDetailResponseDto>
        get() = _cardDetailResult



    fun getCardDetails( ) {
        handleProgress(true)
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getCardDetails()
            data.either(::handleFailure, ::handleCardDetail)
        }
    }

    private fun handleCardDetail(cardDetailResponseDto: CardDetailResponseDto) {
        handleProgress(false)
        _cardDetailResult.postValue(cardDetailResponseDto)
    }

}

