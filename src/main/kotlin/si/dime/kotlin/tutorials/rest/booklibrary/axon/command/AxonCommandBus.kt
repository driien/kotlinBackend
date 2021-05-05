package si.dime.kotlin.tutorials.rest.booklibrary.axon.command

import arrow.core.Either
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.stereotype.Component
import si.dime.kotlin.tutorials.rest.booklibrary.librarysource.commandquery.command.CommandBus
import si.dime.kotlin.tutorials.rest.booklibrary.librarysource.fp.catch
import kotlin.reflect.KClass

@Component
class AxonCommandBus(private val commandGateway: CommandGateway) : CommandBus {
    override fun <C> execute(command: C) {
        commandGateway.sendAndWait<C>(command)
    }

    override fun <C, R : Any> execute(command: C, responseType: KClass<R>): R {
        return commandGateway.sendAndWait(command)
    }

    override fun <C, R> failureOrSuccess(command: C): Either<Throwable, R> = catch {
        commandGateway.sendAndWait(command)
    }

    override fun <C, R, E> safeExecute(command: C): Either<E, R> = commandGateway.sendAndWait(command)
}
