package com.blu.bank.challenge.common.base

import androidx.annotation.Keep

@Keep
abstract class BaseResponseModel(val success:String? =null , val error:String?  = null )




//  server non 200 codes
const val BAD_REQUEST = 400




