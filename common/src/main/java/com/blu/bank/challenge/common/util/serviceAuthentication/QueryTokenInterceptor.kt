package com.blu.bank.challenge.common.util.serviceAuthentication

import okhttp3.Interceptor
import okhttp3.Response


class QueryTokenInterceptor(
        private val authHeader:String,
     ) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
                .addQueryParameter(authHeader, "d7ee9c2f911332156d4a26125fd74fe6")
                .build()

        val requestBuilder = original.newBuilder()
                .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }


}

