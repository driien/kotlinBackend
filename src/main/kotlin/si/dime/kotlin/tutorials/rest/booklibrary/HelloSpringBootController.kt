package si.dime.kotlin.tutorials.rest.booklibrary

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloSpringBootController {

    @RequestMapping("/hello")
    fun helloSpringBoot():String  = "Hello SpringBoot\n /api-books to see allBooks"

}