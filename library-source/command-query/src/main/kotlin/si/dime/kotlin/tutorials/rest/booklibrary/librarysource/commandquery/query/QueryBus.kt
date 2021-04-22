package si.dime.kotlin.tutorials.rest.booklibrary.librarysource.commandquery.query

import arrow.core.Either

import kotlin.reflect.KClass

interface QueryBus {
    @Deprecated(message = "Use failureOrSuccess instead")
    fun <Q, R : Any> ask(query: Q, responseType: KClass<R>): R
    fun <Q, R : Any> ask(query: Q, responseType: List<KClass<R>>): List<R>
    fun <Q, R : Any> failureOrSuccess(query: Q, successType: KClass<R>): Either<Throwable, R>
}

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
inline fun <reified R : Any> QueryBus.execute(query: Any): Either<Throwable, R> = catch {
    failureOrSuccess(query, R::class)
}
