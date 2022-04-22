package com.blu.bank.challenge.common.base

import android.accounts.NetworkErrorException
import com.blu.bank.challenge.common.exception.Failure
import com.blu.bank.challenge.common.util.Either
import com.google.gson.JsonParseException
import io.reactivex.*
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import retrofit2.Response
import java.io.IOException


interface BaseRepository {
    suspend fun <T:BaseResponseModel,R> networkRequest(
        call: suspend () -> Response<T>,
        transform: suspend (T) -> R,
        default: T
    ): Either<Failure, R>

}

open class BaseRepositoryDelegation() : BaseRepository {

    override suspend fun <T:BaseResponseModel,R> networkRequest( call: suspend () -> Response<T>, transform: suspend (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.invoke()
            when (response.isSuccessful) {
                true -> Either.Right(transform(response.body()?:default))
                false -> Either.Left(handleHttpError(response))
            }

        } catch (exception: Exception) {
            exception.printStackTrace()
            Either.Left(handleInternalError(exception))
        }
    }



}


fun <T> handleHttpError(response: Response<T>): Failure {
    return when (response.code()) {
        BAD_REQUEST -> (Failure.ServerMessageError(response.errorBody()?.string()?.toString() ?: "", 0))

        in (500..600) -> (Failure.InternalServer)
        else -> Failure.UnExpected
    }
}




fun handleInternalError(exception: Exception): Failure {
    return when (exception) {
        is IOException -> Failure.NetworkConnection
        is JsonParseException -> Failure.JsonParse
        is NetworkErrorException -> Failure.NetworkConnection
        else -> Failure.Internal
    }
}
