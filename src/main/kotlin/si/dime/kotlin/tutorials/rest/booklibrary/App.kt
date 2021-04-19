package si.dime.kotlin.tutorials.rest.booklibrary

import com.kotato.cqrs.application.EnableCqrs
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableCqrs

open class App

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}