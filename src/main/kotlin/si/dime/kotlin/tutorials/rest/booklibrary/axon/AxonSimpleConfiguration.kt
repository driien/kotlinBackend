package si.dime.kotlin.tutorials.rest.booklibrary.axon

import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.commandhandling.gateway.DefaultCommandGateway
import org.axonframework.eventhandling.EventBus
import org.axonframework.eventhandling.SimpleEventBus
import org.axonframework.queryhandling.DefaultQueryGateway
import org.axonframework.queryhandling.QueryBus
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.SimpleQueryBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class AxonSimpleConfiguration {
    @Bean
    open fun commandBus(): CommandBus = SimpleCommandBus.builder().build()

    @Bean
    open fun commandGateway(): CommandGateway = DefaultCommandGateway.builder().commandBus(commandBus()).build()

    @Bean
    open fun queryBus(): QueryBus = SimpleQueryBus.builder().build()

    @Bean
    open fun queryGateway(): QueryGateway = DefaultQueryGateway.builder().queryBus(queryBus()).build()

    @Bean
    open fun eventBus(): EventBus = SimpleEventBus.builder().build()
}
