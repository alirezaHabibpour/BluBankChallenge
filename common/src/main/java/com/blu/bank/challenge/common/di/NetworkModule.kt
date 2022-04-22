package com.blu.bank.challenge.common.di

import com.blu.bank.challenge.common.BuildConfig
import com.blu.bank.challenge.common.util.mockserver.MockInterceptor
import com.blu.bank.challenge.common.util.serviceAuthentication.QueryTokenInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//names for anonymous  server modules
const val ANONYMOUS_CLIENT = "ANONYMOUS_CLIENT"
const val ANONYMOUS_RETROFIT = "ANONYMOUS_RETROFIT"

//names for authenticated  server modules
const val AUTHENTICATED_INTERCEPTOR = "AUTHENTICATED_INTERCEPTOR"
const val AUTHENTICATED_CLIENT = "AUTHENTICATED_CLIENT"
const val AUTHENTICATED_RETROFIT = "AUTHENTICATED_RETROFIT"



//names for mock server modules
const val MOCK_SERVER_RETROFIT = "MOCK_SERVER_RETROFIT"
const val MOCK_SERVER_CLIENT = "MOCK_SERVER_CLIENT"

// base network constants names  that provided by app module
const val APP_BASE_URL = "APP_BASE_URL"
const val APP_NETWORK_TIMEOUT = "APP_NETWORK_TIMEOUT"

// headers name that provided by app module
const val APP_AUTH_TOKEN = "access_key"



@JvmField
val networkModule = module {

    single { provideGson() }





    //mock server client
    single (named(MOCK_SERVER_CLIENT)){ provideMockOkhttpClient() }
    single(named(MOCK_SERVER_RETROFIT)) { provideRetrofitModule(get(named(MOCK_SERVER_CLIENT)), get(),get(named(APP_BASE_URL))) }


    // anonymous client
    single(named(ANONYMOUS_CLIENT)) { provideDefaultOkhttpClient() }
    single(named(ANONYMOUS_RETROFIT)) { provideRetrofitModule(get(named(ANONYMOUS_CLIENT)), get(),get(named(APP_BASE_URL))) }


    //authenticated client
    single(named(AUTHENTICATED_INTERCEPTOR)) { QueryTokenInterceptor(APP_AUTH_TOKEN ) }
    single(named(AUTHENTICATED_CLIENT)) { provideAuthenticatedOkhttpClient(get(named(AUTHENTICATED_INTERCEPTOR)),get(named(APP_NETWORK_TIMEOUT))) }
    single(named(AUTHENTICATED_RETROFIT)) { provideRetrofitModule(get(named(AUTHENTICATED_CLIENT)),get(),get(named(APP_BASE_URL))) }


}


inline fun <reified T> createNetwork(service: Class<T>, retrofit: Retrofit): T = retrofit.create(T::class.java)


fun provideDefaultOkhttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()

    if ((BuildConfig.DEBUG)) {
        val i = HttpLoggingInterceptor()
        i.setLevel(HttpLoggingInterceptor.Level.BODY)
        //cast as Any for release mode
        builder.addNetworkInterceptor(i as Any as Interceptor)

    }

    return builder.build()
}



fun provideMockOkhttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .addInterceptor(MockInterceptor())
            .build()

}

fun provideAuthenticatedOkhttpClient(authenticateInterceptor: Interceptor,timeout: Long): OkHttpClient {

    val builder = OkHttpClient.Builder()
    builder.addInterceptor(authenticateInterceptor)
            .readTimeout(timeout, TimeUnit.MILLISECONDS)
            .writeTimeout(timeout, TimeUnit.MILLISECONDS)
            .connectTimeout(timeout, TimeUnit.MILLISECONDS)

    if (BuildConfig.DEBUG){
        val i = HttpLoggingInterceptor()
        i.setLevel(HttpLoggingInterceptor.Level.BODY)
        //cast as Any for release mode
        builder.addNetworkInterceptor(i as Any as Interceptor)
    }

    return builder.build()
}




fun provideRetrofitModule(client: OkHttpClient, gosn: Gson,baseUrl: String): Retrofit {
    return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gosn))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}





fun provideGson(): Gson {
    return GsonBuilder().serializeNulls()
            .create()
}

