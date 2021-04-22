package si.dime.kotlin.tutorials.rest.booklibrary.primary.adapter

import org.axonframework.queryhandling.QueryBus
import org.springframework.web.bind.annotation.*
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.Book
import si.dime.kotlin.tutorials.rest.booklibrary.book.domain.DuplicateItemException

@RestController
class BooksController (private val queryBus: QueryBus){

    @GetMapping("/api-books")
    fun search(){
        // TODO BookDocumentList
    }

    @PostMapping("/book")
    fun addBook(@RequestBody book: Book) {
        if (database.addBook(book)) {
            book
        }
        else {
            throw DuplicateItemException()
        }
    }
}