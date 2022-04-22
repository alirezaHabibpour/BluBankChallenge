package com.blu.bank.challenge.common.util.mockserver

import com.blu.bank.challenge.common.BuildConfig
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException

class MockInterceptor : Interceptor {


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var response: Response? = null
        var fakeResponse = ""
        if (BuildConfig.DEBUG) {
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            fakeResponse =
                when {
                    chain.request().url.toString().contains("getCardDetails") -> json
                    else -> ""
                }

            response = Response.Builder()
                .code(200)
                .message(fakeResponse)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(null, fakeResponse.toByteArray()))
                .addHeader("content-type", "application/json")
                .build()
        } else {
            response = chain.proceed(chain.request())
        }
        return response
    }


    val json = """{"success":"true","cardNumber":"5859471010579567","expDate":"1403:03","cardOwnerLastName":" حبیب پور","cardOwnerFirstName":"علیرضا","cvv2":"3435"}""".trim()

}

