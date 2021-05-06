package si.dime.kotlin.tutorials.rest.booklibrary.axon.query

import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.stereotype.Component
import arrow.core.Either
import arrow.core.Either.Left
import arrow.core.Either.Right
import si.dime.kotlin.tutorials.rest.booklibrary.librarysource.commandquery.query.QueryBus
import kotlin.reflect.KClass

@Component
class AxonQueryBus(private val queryGateway: QueryGateway) : QueryBus {
    override fun <Q, R : Any> ask(query: Q, responseType: KClass<R>): R {
        return runCatching { queryGateway.query(query, ResponseTypes.instanceOf(responseType.java)).get() }
            .fold(
                onSuccess = { it },
                onFailure = { throw it.cause!! }
            )
    }

    override fun <Q, R : Any> ask(query: Q, responseType: List<KClass<R>>): List<R> {
        return runCatching {
            queryGateway.query(query, ResponseTypes.multipleInstancesOf(responseType.first().java)).get()
        }.fold(
            onSuccess = { it },
            onFailure = { throw it.cause!! }
        )
    }

    override fun <Q, R : Any> failureOrSuccess(query: Q, successType: KClass<R>): Either<Throwable, R> {
        return kotlin.runCatching { queryGateway.query(query, ResponseTypes.instanceOf(successType.java)).get() }.fold(
            onSuccess = { Right(it) },
            onFailure = { Left(it.cause!!) }
        )
    }
}
