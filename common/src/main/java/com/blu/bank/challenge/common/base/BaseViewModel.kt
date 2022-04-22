package com.blu.bank.challenge.common.base

import androidx.lifecycle.*
import com.blu.bank.challenge.common.exception.Failure
import com.blu.bank.challenge.common.util.livedata.SingleLiveEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {


    var failure: SingleLiveEvent<Failure?> = SingleLiveEvent()
    var success: SingleLiveEvent<Boolean?> = SingleLiveEvent()
    var progress: SingleLiveEvent<Boolean?> = SingleLiveEvent()

    var generalFailure: SingleLiveEvent<Failure> = SingleLiveEvent()


    protected open fun handleFailure(mFailure: Failure) {
        handleProgress(hasProgress = false, isSuccessEnd = false)
        viewModelScope.launch {
            failure.postValue(mFailure)
            generalFailure.postValue(mFailure)
        }


    }

    protected fun handleProgress(hasProgress: Boolean, isSuccessEnd: Boolean = true) {
        if (hasProgress) {
            this.progress.postValue(hasProgress)
        } else {
            this.success.postValue(isSuccessEnd)
            viewModelScope.launch {
                progress.postValue(hasProgress)
            }
        }
        viewModelScope.launch {
            success.postValue(null)
            failure.postValue(null)
        }
    }


}