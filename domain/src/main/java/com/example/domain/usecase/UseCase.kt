package com.example.domain.usecase


abstract class UseCase<in Params, out T> where T : Any {

    abstract fun invoke(params: Params): T

    abstract suspend fun invokeSuspend(params: Params): T

    open fun onCleared() {}
}
