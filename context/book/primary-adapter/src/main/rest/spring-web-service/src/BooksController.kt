package si.dime.kotlin.tutorials.rest.booklibrary.book.primaryAdapter

import org.axonframework.queryhandling.QueryBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping

@RestController
class BooksController (private val queryBus: QueryBus){

    @GetMapping("/api-books")
    fun search() /** TODO BookDocumentList */

    @PostMapping("/book")
    fun addBook(@RequestBody book: Book) =
        if (database.addBook(book)) book
        else throw DuplicateItemException()

}