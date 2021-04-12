package si.dime.kotlin.tutorials.rest.booklibrary

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}

@SpringBootApplication
open class App {

}