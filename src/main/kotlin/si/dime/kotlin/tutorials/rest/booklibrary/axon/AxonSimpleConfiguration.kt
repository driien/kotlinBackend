package si.dime.kotlin.tutorials.rest.booklibrary.axon

import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.commandhandling.gateway.DefaultCommandGateway
import org.axonframework.eventhandling.EventBus
import org.axonframework.eventhandling.SimpleEventBus
import org.axonframework.eventhandling.gateway.DefaultEventGateway
import org.axonframework.eventhandling.gateway.EventGateway
import org.axonframework.queryhandling.DefaultQueryGateway
import org.axonframework.queryhandling.QueryBus
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.SimpleQueryBus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AxonSimpleConfiguration {
    @Bean
    fun commandBus(): CommandBus = SimpleCommandBus.builder().build()

    @Bean
    fun commandGateway(): CommandGateway = DefaultCommandGateway.builder().commandBus(commandBus()).build()

    @Bean
    fun queryBus(): QueryBus = SimpleQueryBus.builder().build()

    @Bean
    fun queryGateway(): QueryGateway = DefaultQueryGateway.builder().queryBus(queryBus()).build()

    @Bean
    fun eventBus(): EventBus = SimpleEventBus.builder().build()

    @Bean
    fun eventGateway(): EventGateway = DefaultEventGateway.builder().eventBus(eventBus()).build()
}
