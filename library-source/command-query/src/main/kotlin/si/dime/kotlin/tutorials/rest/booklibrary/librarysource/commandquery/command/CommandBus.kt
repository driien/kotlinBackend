package si.dime.kotlin.tutorials.rest.booklibrary.librarysource.commandquery.command

import arrow.core.Either
import kotlin.reflect.KClass

interface CommandBus {
    fun <C> execute(command: C)
    fun <C, R : Any> execute(command: C, responseType: KClass<R>): R
    fun <C, R> failureOrSuccess(command: C): Either<Throwable, R>
}

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
inline fun <reified R> CommandBus.execute(command: Any): Either<Throwable, R> = failureOrSuccess(command)
