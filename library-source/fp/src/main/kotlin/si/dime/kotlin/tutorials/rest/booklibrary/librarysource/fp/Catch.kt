package si.dime.kotlin.tutorials.rest.booklibrary.librarysource.fp

import arrow.core.Either
import arrow.core.left

fun <R> catch(execution: () -> Either<Throwable, R>): Either<Throwable, R> = try {
    execution()
} catch (exception: Throwable) {
    exception.left()
}
