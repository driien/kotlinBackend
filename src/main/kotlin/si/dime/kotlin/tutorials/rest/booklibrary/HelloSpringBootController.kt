package si.dime.kotlin.tutorials.rest.booklibrary

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloSpringBootController {

    @RequestMapping("/hello")
    fun helloSpringBoot() = "Hello SpringBoot\n /books to see allBooks"

}